package scoring;

import datastruct.Item;
import datastruct.feature.Square;

import java.util.List;

public class FSquareScoring extends Scoring<Square> {
    public FSquareScoring(List<Item> historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {

    }

    public double score(Item item) {
        return 0;
    }
}
