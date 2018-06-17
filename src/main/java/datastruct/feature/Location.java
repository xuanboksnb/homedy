package datastruct.feature;

import datastruct.Pair;

public class Location extends IFeature<Pair<String, String>> {
    public Location(Pair<String, String> value) {
        super(value);
    }

    public FeatureType getType() {
        return FeatureType.LOCATION;
    }

    public String getLevel1() {
        return value.getLeft();
    }

    public String getLevel2() {
        return value.getRight();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location))
            return false;

        Location other = (Location) obj;
        return this.value.getLeft().equals(other.value.getLeft()) && this.value.getRight().equals(other.value.getRight());
    }

    @Override
    public int hashCode() {
        return (value.getLeft() + "_" + value.getRight()).hashCode();
    }
}
