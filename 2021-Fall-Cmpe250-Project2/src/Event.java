

public class Event implements Comparable<Event> {
	public String eventType;
	public double eventTime;
	public Player player;
	public double eventDuration;
	public Event(String eventType, double eventTime,double eventDuration, Player player) {
		this.eventType = eventType;
		this.eventTime = eventTime;
		this.player = player;
		this.eventDuration = eventDuration;
	}
	
	@Override
	public int compareTo(Event e) {
		if (Math.abs(this.eventTime - e.eventTime)  > 0.0000000001) {
			if (this.eventTime > e.eventTime) {
				return 1;
			}	
			else {
				return -1;
			}
		}
		else {
			return this.player.getId() - e.player.getId();
		}
	}
}
