import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class dGraph {
	int numberOfVertex;
	private Map<Integer, Map<Integer, Integer>> adjacencyMap;
	int minWeight;
	boolean isAllCitiesVisited;
	public dGraph(int numberOfVertex) {
		this.numberOfVertex = numberOfVertex;
		adjacencyMap = new HashMap<Integer, Map<Integer, Integer>>();
		for(int a=0 ; a < numberOfVertex ; a++) {
			adjacencyMap.put(a, new HashMap<Integer,Integer>());
		}
		this.minWeight = 0;
		this.isAllCitiesVisited = true;
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
	
	public void findMinimumSpanningTree(int sourceVertex) {
		int mstTax = 0;
        PriorityQueue<Pair> myQueue = new PriorityQueue<Pair>();
        
        myQueue.add(new Pair(sourceVertex,0));	
		
        boolean visited[] = new boolean[numberOfVertex];
        Arrays.fill(visited, false);
		
        while (myQueue.size()>0) {
        	Pair edge = myQueue.poll();        	
        	int sourceVertexx = edge.vertice;
        	int weight = edge.weight;
        	
        	if(!visited[sourceVertexx]) {
        		mstTax += weight;
        		visited[sourceVertexx] = true;
        		
        		for (int targetVertex : adjacencyMap.get(sourceVertexx).keySet()) {
        			if(!visited[targetVertex]) {
        				Pair pair = new Pair(targetVertex,adjacencyMap.get(sourceVertexx).get(targetVertex));
        				myQueue.add(pair);
        			}
        		}
        	}
        }
        this.minWeight = mstTax;
        for(boolean x : visited) {
        	if (x == false) {
        		this.isAllCitiesVisited = false;
        	}
        }
	}
}
