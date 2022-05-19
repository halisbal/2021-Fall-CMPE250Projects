import java.util.Arrays;

public class Algorithm {
	
	static boolean BfsAlgorithm(Graph graph,int source, int target, int[] distances) {
//		filling distances array with -1
		for(int a = 0; a < distances.length ; a++) {
			distances[a] = -1;
		}

//		setting source distance as 0
		distances[source] = 0;
		int[] queueArray = new int[graph.vertexList.size()];
		int queueNum = 0;
		queueArray[queueNum] = source;
		queueNum++;
		for(int a = 0 ; a<queueNum;a++) {
			int x = queueArray[a];
			for (Edge edge : graph.vertexList.get(x).adjacencyList) {
				if(distances[edge.to.id] < 0 && edge.flow < edge.capacity) {
					distances[edge.to.id] = distances[x]+1;
					queueArray[queueNum++] = edge.to.id;
				}
			}
		}
		return distances[target] >= 0;
	}
	static int DfsAlgorithm(Graph graph, int[] distances, int target,int[] lst, int source, int flow) {
//		setting recursion constraint
		if(source==target) {
			return flow;
		}
		
		for (int x = 0;lst[source] < graph.vertexList.get(source).adjacencyList.size();lst[source]++) {
			Edge edge = graph.vertexList.get(source).adjacencyList.get(lst[source]);
			
			if (distances[edge.to.id] == distances[source] +1 && edge.flow < edge.capacity ) {
				int result = DfsAlgorithm(graph,distances,target,lst,edge.to.id,Math.min(flow, edge.capacity - edge.flow));
				
				if(result > 0) {
					graph.reverseEdgeMap.get(edge).flow -= result;
					edge.flow += result;
					return result;
				}
			}
		}
		
		return 0;
	}
	
	public static int maxFlow(Graph graph, int source, int sink) {
		int maxFlow = 0;
		int[] distances = new int[graph.vertexList.size()];
		
		while(BfsAlgorithm(graph,source,sink,distances)) {
			int[] lst = new int[graph.vertexList.size()];
			while (true) {
				int result = DfsAlgorithm(graph,distances,sink,lst,source,999999999);
				if (result==0) {
					break;
				}
				maxFlow += result;
			}
		}
		return maxFlow;
	}
}
