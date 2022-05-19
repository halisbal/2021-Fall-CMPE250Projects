import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	HashMap<Edge,Edge> reverseEdgeMap;
	ArrayList<Vertex> vertexList;
	
	public Graph(ArrayList<Vertex> vertexList,HashMap<Edge,Edge> reverseEdgeMap) {
		this.reverseEdgeMap = reverseEdgeMap;
		this.vertexList = vertexList;
	}
}
