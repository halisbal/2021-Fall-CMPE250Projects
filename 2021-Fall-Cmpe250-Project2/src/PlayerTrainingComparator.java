

import java.util.Comparator;

public class PlayerTrainingComparator implements Comparator<Player> {
    public int compare(Player s1, Player s2) {
        if ( Math.abs(s1.getTrainingArrivalTime() - s2.getTrainingArrivalTime()) > 0.0000000001) {
            if (s1.getTrainingArrivalTime() < s2.getTrainingArrivalTime()) {
            	return -1;
            }
            else {
            	return 1;
            }
        }
        else {
            return s1.getId() - s2.getId();
        }
    }
}
