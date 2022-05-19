

public class Physiotherapist implements Comparable<Physiotherapist> {
	public int id;
	public double serviceTime;
	
	public Physiotherapist(int id, double serviceTime) {
		this.id = id;
		this.serviceTime = serviceTime;
	}
	
	@Override
	public int compareTo(Physiotherapist e) {
		return (int)(this.id-e.id);
	}
}
