package scoring;

import datastruct.Item;

import java.util.List;

/**
 * Scoring for an item.
 */
public class ItemScoring extends Scoring {
    public ItemScoring(List<Item> historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {

    }

    public double score(Item item) {
        return 0;
    }
}
