package datastruct.feature;

import datastruct.Pair;

public class Acreage extends IFeature<Pair<Double, Double>> {

    public Acreage(Pair<Double, Double> value) {
        super(value);
    }

    public FeatureType getType() {
        return FeatureType.ACREAGE;
    }
}
