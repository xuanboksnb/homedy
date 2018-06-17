package scoring;

import datastruct.Item;
import datastruct.feature.RoomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FRoomNumberScoring extends Scoring<RoomNumber> {

    private Map<RoomNumber, Double> roomWeight;

    public FRoomNumberScoring(List<Item> historyItems) {
        super(historyItems);
        extractedFeature = new ArrayList<>();
    }

    protected void featureExtracting() {
        if (this.historyItems == null)
            return;

        List<Integer> viewedRoomNumbers = new ArrayList<>();
        for (int i = 0; i < historyItems.size(); i ++) {
            if (historyItems.get(i).getRoomNumber().value > 0)
                viewedRoomNumbers.add(historyItems.get(i).getRoomNumber().value);
        }

        double mean = 0.0;
        for (int i : viewedRoomNumbers)
            mean += i;
        if (viewedRoomNumbers.size() > 0) {
            mean /= viewedRoomNumbers.size();

            double scores[] = new double[]{60, 100, 80, 60};
            for (int i = 0; i < scores.length; i++) {
                roomWeight.put(new RoomNumber((int) (i + mean - 1)), scores[i]);
            }
        }
    }

    public double score(Item item) {
        if (item.getRoomNumber().value > 0 && roomWeight.containsKey(item.getRoomNumber())) {
            return roomWeight.get(item.getRoomNumber());
        }
        else
            return 0;
    }
}
