package scoring;

import datastruct.Item;
import datastruct.feature.Price;

import java.util.List;

public class FPriceScoring extends Scoring<Price> {
    public FPriceScoring(List<Item> historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {

    }

    public double score(Item item) {
        return 0;
    }
}
