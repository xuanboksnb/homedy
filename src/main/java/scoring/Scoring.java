package scoring;

import datastruct.Filter;
import datastruct.Item;
import datastruct.Pair;
import datastruct.feature.IFeature;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class define common behaviors of a scoring features which sharing the same input.
 * Every score which calculated by child-class must be normalized into range of [0;100]
 * @param <K>: FeatureType corresponding to concrete class which implemented.
 */
public abstract class Scoring<K> {

    public Scoring(List<Item> historyItems) {
        this.historyItems = historyItems;
        featureExtracting();
    }

    /**
     * history items viewed of an user
     */
    protected List<Item> historyItems;

    /**
     * the currently viewing item
     */
    protected Item mainItem;

    /**
     * filter comes from referer of an item, such as listing or query.
     */
    protected Filter filter;

    /**
     * variable holding processed result of featureExtracting()
     * the basic version: just store every features sorted by view_time.
     */
    protected List<Pair<K, Double>> extractedFeature;

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
