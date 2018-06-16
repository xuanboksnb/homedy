package scoring;

import datastruct.Item;
import datastruct.feature.RoomNumber;

public class FRoomNumberScoring extends Scoring<RoomNumber> {
    public FRoomNumberScoring(Item[] historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {

    }

    public double score(Item item) {
        return 0;
    }
}
