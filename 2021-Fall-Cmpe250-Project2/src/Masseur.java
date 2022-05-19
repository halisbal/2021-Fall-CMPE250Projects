

public class Masseur implements Comparable<Masseur> {
	public int id;
	public Masseur(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Masseur e) {
		return (int)(this.id-e.id);
	}
}
