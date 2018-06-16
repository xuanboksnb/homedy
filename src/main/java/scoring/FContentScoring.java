package scoring;

import datastruct.Item;
import datastruct.feature.Content;

import java.util.List;

public class FContentScoring extends Scoring<Content> {
    public FContentScoring(List<Item> historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {

    }

    public double score(Item item) {
        return 0;
    }
}
