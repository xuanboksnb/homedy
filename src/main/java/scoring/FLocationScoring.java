package scoring;

import datastruct.Item;
import datastruct.feature.Location;

import java.util.ArrayList;

public class FLocationScoring extends Scoring<Location> {

    public FLocationScoring(Item[] historyItems) {
        super(historyItems);
    }

    protected void featureExtracting() {
        if (this.historyItems == null)
            return;

        extractedFeature = new ArrayList<>();
        for (int i = 0; i < historyItems.length; i ++) {

        }
    }

    public double score(Item item) {
        return 0;
    }
}
