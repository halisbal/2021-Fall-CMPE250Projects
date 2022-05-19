public class Pair implements Comparable<Pair> {
	int vertice;
	int weight;
	
	public Pair(int vertice, int distanceFromSource) {
		this.vertice = vertice;
		this.weight = distanceFromSource;
	}
	
	@Override
	public int compareTo(Pair e) {
	    return (int)(this.weight - e.weight);
	}
}
