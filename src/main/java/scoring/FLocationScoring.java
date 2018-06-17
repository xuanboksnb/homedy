package scoring;

import datastruct.Item;
import datastruct.Pair;
import datastruct.feature.Location;

import java.util.*;

/**
 * Class uses for scoring
 */
public class FLocationScoring extends Scoring<Location> {

    private Map<Location, Double> locWeight;

    public FLocationScoring(List<Item> historyItems) {
        super(historyItems);
        Collections.sort(historyItems, Comparator.comparing(Item::getViewedTime));
        mainItem = historyItems.get(0);
        locWeight = new HashMap<>();
        extractedFeature = new ArrayList<>();
    }

    /**
     * extractedFeature stores location's frequency
     */
    protected void featureExtracting() {
        if (this.historyItems == null)
            return;

        Map<Location, Integer> locFrequency = new HashMap<>();
        for (int i = 0; i < historyItems.size(); i ++) {
            Location l = historyItems.get(i).getLocation();
            locFrequency.put(l, 1 + (locFrequency.containsKey(l) ? locFrequency.get(l) : 0));
        }

        for (Location l : locFrequency.keySet()) {
            extractedFeature.add(new Pair<>(l, (double) locFrequency.get(l)));
        }

        weighting();
    }

    public double score(Item item) {
        if (locWeight.containsKey(item.getLocation()))
            return locWeight.get(item.getLocation());
        else
            return 0;
    }

    /**
     * calculating & normalizing weight for every location by it's frequency,
     * but set priority for location of current viewing.
     */
    private void weighting() {
        for (Pair<Location, Double> p : extractedFeature) {
            if (p.getLeft().equals(mainItem.getLocation()))
                locWeight.put(p.getLeft(), 50.0);
            else
                locWeight.put(p.getLeft(), 50.0 * p.getRight() / historyItems.size());
        }
    }

    /**
     * @return all location that has been viewed.
     */
    public List<Location> getViewedLocation() {
        return new ArrayList<>(locWeight.keySet());
    }

}
