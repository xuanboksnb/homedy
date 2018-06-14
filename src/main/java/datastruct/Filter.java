package datastruct;

import datastruct.feature.IFeature;
import datastruct.feature.Location;

public class Filter {
    private IFeature[] features;

    public IFeature[] getFeatures() {
        if (features[0].getType() == IFeature.FeatureType.LOCATION) {
            Location l = (Location) features[0];
        }
        return features;
    }
}
