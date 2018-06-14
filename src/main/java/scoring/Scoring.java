package scoring;

import datastruct.Item;
import datastruct.feature.IFeature;

public abstract class Scoring {
    private Item[] historyItems;
    private IFeature[] extractedFeature;

    protected abstract void featureExtracting();
    public abstract double score(Item item);
}
