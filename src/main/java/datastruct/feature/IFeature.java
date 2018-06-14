package datastruct.feature;

/**
 * Class represents common attribute & behavior of a item.feature
 * @param <V>: DataType of corresponding feature.
 */
public abstract class IFeature<V> {
    public enum FeatureType {
        SQUARE,
        PRICE,
        LOCATION,
        CONTENT,
        ROOM_NUMBER
    }

    public V value;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public abstract FeatureType getType();
}
