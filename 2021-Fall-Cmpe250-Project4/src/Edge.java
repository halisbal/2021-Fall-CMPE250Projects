
public class Edge {
	Vertex from;
	Vertex to;
	int capacity;
	int flow;
	
	public Edge(Vertex from, Vertex to, int capacity,int flow) {
		this.from = from;
		this.to = to;
		this.capacity = capacity;
		this.flow = flow;	
	}
}
