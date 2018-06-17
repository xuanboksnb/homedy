package scoring;

import datastruct.Item;
import datastruct.Pair;
import datastruct.feature.Price;

import java.util.ArrayList;
import java.util.List;

public class FPriceScoring extends Scoring<Price> {

    /**
     * @preferencePrice: represent for user's preference price.
     */
    private Price preferencePrice;

    public FPriceScoring(List<Item> historyItems) {
        super(historyItems);
        extractedFeature = new ArrayList<>();
    }

    protected void featureExtracting() {
        if (this.historyItems == null)
            return;

        for (int i = 0; i < historyItems.size(); i ++) {
            Price p = historyItems.get(i).getPrice();
            extractedFeature.add(new Pair<>(p, (double) historyItems.get(i).getViewedTime()));
        }

        calculatePreferencePrice();
    }

    /**
     * find the most frequent price in a range [average_min; min(max)]
     * @return
     */
    private void calculatePreferencePrice() {
        double min = 0, max = -1;

        for (Pair<Price, Double> p : extractedFeature) {
            min += p.getLeft().value.getLeft();
            if (p.getLeft().value.getRight() != null) {
                if (max < 0)
                    max = p.getLeft().value.getRight();
                else
                    max = Math.min(max, p.getLeft().value.getRight());
            }
        }

        min /= extractedFeature.size();
        if (max < 0 || max < min)
            max = min * 1.5;

        this.preferencePrice = new Price(new Pair<>(min, max));
    }

    public double score(Item item) {
        // price_score = 100 - x * slope
        int x;
        double slope;

        // get 'representative price' for this item.
        double iPrice = item.getPrice().getValue().getLeft();
        if (item.getPrice().getValue().getRight() != null) {
            iPrice += item.getPrice().getValue().getRight();
            iPrice /= 2;
        }

        // get 'x' & 'slope'
        if (iPrice < preferencePrice.getValue().getLeft()) {
            x = 1;
            slope = 100.0 * iPrice / preferencePrice.getValue().getLeft();
        }
        else if (iPrice > preferencePrice.getValue().getRight()) {
            x = 2;
            slope = 100 * preferencePrice.getValue().getRight() / iPrice;
        }
        else {
            x = 0;
            slope = 0;
        }

        return Math.min(0, 100.0 - x * slope);
    }
}
