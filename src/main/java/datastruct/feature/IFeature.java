package datastruct.feature;

public abstract class IFeature<V> {
    public V value;
    public enum FeatureType {
        SQUARE,
        PRICE,
        LOCATION
    }

    public V getValue() {
        return value;
    }

    public abstract FeatureType getType();
}
