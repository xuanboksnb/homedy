package scoring;

import datastruct.Item;
import datastruct.Pair;
import datastruct.feature.Acreage;
import datastruct.feature.Price;

import java.util.List;

public class FAcreageScoring extends Scoring<Acreage> {

    /**
     * @preferenceSquare: represent for user's preference acreage.
     */
    private Acreage preferenceAcreage;

    public FAcreageScoring(List<Item> historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {
        if (this.historyItems == null)
            return;

        for (int i = 0; i < historyItems.size(); i ++) {
            Acreage a = historyItems.get(i).getAcreage();
            extractedFeature.add(new Pair<>(a, (double) historyItems.get(i).getViewedTime()));
        }


    }


    /**
     * find the most frequent acreage in a range [average_min; min(max)]
     * @return
     */
    private void calculatePreferenceAcreage() {
        double min = 0, max = -1;

        for (Pair<Acreage, Double> p : extractedFeature) {
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

        this.preferenceAcreage = new Acreage(new Pair<>(min, max));
    }

    public double score(Item item) {
        // acreage_score = 100 - x * slope
        int x;
        double slope;

        // get 'representative acreage' for this item.
        double iAcreage = item.getAcreage().getValue().getLeft();
        if (item.getAcreage().getValue().getRight() != null) {
            iAcreage += item.getAcreage().getValue().getRight();
            iAcreage /= 2;
        }

        // get 'x' & 'slope'
        if (iAcreage < preferenceAcreage.getValue().getLeft()) {
            x = 1;
            slope = 100.0 * iAcreage / preferenceAcreage.getValue().getLeft();
        }
        else if (iAcreage > preferenceAcreage.getValue().getRight()) {
            x = 2;
            slope = 100 * preferenceAcreage.getValue().getRight() / iAcreage;
        }
        else {
            x = 0;
            slope = 0;
        }

        return Math.min(0, 100.0 - x * slope);
    }
}
