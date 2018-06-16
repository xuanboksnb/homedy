package scoring;

import datastruct.Item;
import datastruct.feature.Price;

public class FPriceScoring extends Scoring<Price> {
    public FPriceScoring(Item[] historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {

    }

    public double score(Item item) {
        return 0;
    }
}
