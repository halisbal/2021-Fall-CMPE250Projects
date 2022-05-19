import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class cGraph {
	int numberOfVertex;
	private Map<Integer, Map<Integer, Integer>> adjacencyMap;
	ArrayList<Integer> path;
	int maxLength;
	public cGraph(int numberOfVertex) {
		this.numberOfVertex = numberOfVertex;
		adjacencyMap = new HashMap<Integer, Map<Integer, Integer>>();
		for(int a=1 ; a < numberOfVertex+1 ; a++) {
			adjacencyMap.put(a, new HashMap<Integer,Integer>());
		}
		this.path = new ArrayList<Integer>();
		this.maxLength = 0;
	}
	
    public void addVertex(int vertex){
        adjacencyMap.put(vertex, new HashMap<Integer,Integer>());
    }
	
	public void addEdge(int from, int to, int weight) {
		adjacencyMap.get(from).put(to, weight);
	}

	/**
	 * @return the adjacencyMap
	 */
	public Map<Integer, Map<Integer, Integer>> getAdjacencyMap() {
		return adjacencyMap;
	}
	
	public void findShortestPath(int from) {
		PriorityQueue<Pair> myQueue = new PriorityQueue<Pair>();
		ArrayList<Integer> parentList = new ArrayList<Integer>();
		ArrayList<Pair> pairList = new ArrayList<Pair>();

		for(int i = 0 ; i<numberOfVertex+1; i++) {
			parentList.add(0);
		}
		
		Pair pair1 = new Pair(1,0);
		myQueue.add(pair1);
		pairList.add(pair1);
		for(int i = 2 ; i < numberOfVertex+1 ; i++) {
			Pair pairOther = new Pair(i,Integer.MAX_VALUE/2);
			myQueue.add(pairOther);
			pairList.add(pairOther);
		}
		
		while (myQueue.size()>0) {
			Pair myPair = myQueue.poll();
			int vertex = myPair.vertice;
			for(int adjacentVertex : adjacencyMap.get(vertex).keySet()) {
				if(pairList.get(adjacentVertex-1).weight > myPair.weight + adjacencyMap.get(vertex).get(adjacentVertex)) {
					myQueue.remove(pairList.get(adjacentVertex-1));
					parentList.set(adjacentVertex, vertex);
					Pair updatedPair = new Pair(adjacentVertex,adjacencyMap.get(vertex).get(adjacentVertex) + myPair.weight);
					myQueue.add(updatedPair);
					pairList.set(adjacentVertex-1, updatedPair);
				}
			}
		}
		int index = numberOfVertex;
		path.add(numberOfVertex);
		maxLength = pairList.get(pairList.size()-1).weight;
		while (true) {
			path.add(parentList.get(index));
			index = parentList.get(index);
			if(index==0) {
				break;
			}
		}
	}
}