import java.util.ArrayList;

public class Vertex {
	
	int id;
	ArrayList<Edge> adjacencyList;
	
	public Vertex(int id) {
		this.id = id;
		this.adjacencyList = new ArrayList<Edge>();
	}
	public void addAdj(Edge a) {
		this.adjacencyList.add(a);
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
