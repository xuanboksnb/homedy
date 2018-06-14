package datastruct.feature;

import javafx.util.Pair;

public class Location extends IFeature<Pair<String, String>> {
    public FeatureType getType() {
        return FeatureType.LOCATION;
    }
}
