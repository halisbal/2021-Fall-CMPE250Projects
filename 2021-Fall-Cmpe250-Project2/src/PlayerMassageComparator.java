

import java.util.Comparator;

public class PlayerMassageComparator implements Comparator<Player> {
    public int compare(Player s1, Player s2) {
        if ( s1.getSkillLevel() != s2.getSkillLevel()) {
        	return s2.getSkillLevel() - s1.getSkillLevel();
        }
        else if (Math.abs(s1.getMassageArrivalTime() - s2.getMassageArrivalTime()) > 0.0000000001 ) {
            if (s1.getMassageArrivalTime() < s2.getMassageArrivalTime()) {
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
