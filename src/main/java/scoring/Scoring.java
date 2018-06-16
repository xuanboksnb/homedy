package scoring;

import datastruct.Filter;
import datastruct.Item;
import datastruct.Pair;
import datastruct.feature.IFeature;

import java.util.List;

/**
 * Class define common behaviors of a scoring features which sharing the same input.
 * @param <K>: FeatureType corresponding to concrete class which implemented.
 */
public abstract class Scoring<K> {
    public Scoring(Item[] historyItems) {
        this.historyItems = historyItems;
        featureExtracting();
    }

    /**
     * history items viewed of an user
     */
    protected Item[] historyItems;

    /**
     * filter comes from referer of an item, such as listing or query.
     */
    protected Filter filter;

    /**
     * variable holding processed result of featureExtracting()
     * the basic version: just store every features sorted by view_time.
     */
    protected List<Pair<K, Long>> extractedFeature;

    /**
     * extracting common features from input.
     */
    protected abstract void featureExtracting();

    /**
     * calculate similar score for an item.
     * @param item: item need to scoring.
     * @return
     */
    public abstract double score(Item item);
}
