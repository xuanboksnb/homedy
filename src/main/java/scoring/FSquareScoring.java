package scoring;

import datastruct.Item;
import datastruct.feature.Square;

public class FSquareScoring extends Scoring<Square> {
    public FSquareScoring(Item[] historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {

    }

    public double score(Item item) {
        return 0;
    }
}
