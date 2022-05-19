

public class Trainer implements Comparable<Trainer> {
	public int id;
	public Trainer(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Trainer e) {
		return (int)(this.id-e.id);
	}
}
