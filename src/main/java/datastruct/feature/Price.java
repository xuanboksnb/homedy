package datastruct.feature;

import datastruct.Pair;

public class Price extends IFeature<Pair<Double, Double>> {

    public Price(Pair<Double, Double> value) {
        super(value);
    }

    public FeatureType getType() {
        return FeatureType.PRICE;
    }
}
