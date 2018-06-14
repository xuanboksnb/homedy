package datastruct.feature;

import datastruct.Pair;

public class Square extends IFeature<Pair<Double, Double>> {

    public FeatureType getType() {
        return FeatureType.SQUARE;
    }
}
