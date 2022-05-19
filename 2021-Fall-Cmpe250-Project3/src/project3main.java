import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class project3main {
	public static int getIndexOfCity(String cityName,String prefix) {
		return Integer.parseInt(cityName.split(prefix)[1]);
	}
	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		
		int timeLimit = Integer.parseInt(input.nextLine());

		int numberOfCities = Integer.parseInt(input.nextLine());

		String cityIds = input.nextLine();
		String[] a1 = cityIds.split(" ");
		
//		String cityOfMecnun = a1[0];
		String cityOfLeyla = a1[1];
		int numberOfcCity = Integer.parseInt(cityOfLeyla.split("c")[1]);
		
		cGraph cGraph = new cGraph(numberOfcCity);
		dGraph dGraph = new dGraph(numberOfCities-numberOfcCity+1);
		while (input.hasNextLine()) {
			String inputLine = input.nextLine();
				
			if (inputLine.startsWith("c")){
				String[] inputSplitted = inputLine.split(" ");
				
				String sourceCity = inputSplitted[0];
				int tempVar = 1;
				for(int a = 0; a < (inputSplitted.length-1)/2 ; a++) {
					String targetCity = inputSplitted[tempVar];
					int targetLength = Integer.parseInt(inputSplitted[tempVar+1]);
					if(targetCity.startsWith("c")) {
						cGraph.addEdge(getIndexOfCity(sourceCity,"c"),getIndexOfCity(targetCity,"c"),targetLength);
						tempVar += 2;
					}
					else {
						dGraph.addEdge(0, getIndexOfCity(targetCity,"d"), targetLength);
						tempVar += 2;
					}
				}
			}
			if (inputLine.startsWith("d")) {
				String[] inputSplitted = inputLine.split(" ");
				
				String sourceCity = inputSplitted[0];
				int tempVar = 1;
				
				for(int a = 0; a < (inputSplitted.length-1)/2 ; a++) {
					String targetCity = inputSplitted[tempVar];
					int targetLength = Integer.parseInt(inputSplitted[tempVar+1]);
					if(dGraph.getAdjacencyMap().get(getIndexOfCity(sourceCity,"d")).get(getIndexOfCity(targetCity,"d")) == null) {
						dGraph.addEdge(getIndexOfCity(sourceCity,"d"),getIndexOfCity(targetCity,"d"),targetLength);
						dGraph.addEdge(getIndexOfCity(targetCity,"d"),getIndexOfCity(sourceCity,"d"),targetLength);
					}
					else {
						if(targetLength < dGraph.getAdjacencyMap().get(getIndexOfCity(sourceCity,"d")).get(getIndexOfCity(targetCity,"d"))) {
							dGraph.getAdjacencyMap().get(getIndexOfCity(sourceCity,"d")).remove(getIndexOfCity(targetCity,"d"));
							dGraph.getAdjacencyMap().get(getIndexOfCity(targetCity,"d")).remove(getIndexOfCity(sourceCity,"d"));
							
							dGraph.addEdge(getIndexOfCity(sourceCity,"d"),getIndexOfCity(targetCity,"d"),targetLength);
							dGraph.addEdge(getIndexOfCity(targetCity,"d"),getIndexOfCity(sourceCity,"d"),targetLength);
						}
					}
					tempVar += 2;
				}
			}
		}
		cGraph.findShortestPath(0);
//		System.out.println(cGraph.maxLength);
		ArrayList<Integer> outputData = cGraph.path;
		
		outputData.remove(outputData.size()-1);
		Collections.reverse(outputData);
		dGraph.findMinimumSpanningTree(0);

		if(outputData.size() == 1) {
			out.println(-1);
			out.println(-1);
		}
		else {
			for(int i : outputData) {
				out.print("c"+i+" ");
			}
			out.println();
			if (timeLimit < cGraph.maxLength) {
				out.println(-1);
			}
			else if (dGraph.isAllCitiesVisited == false) {
				out.println(-2);
			}
			else {
				out.println(dGraph.minWeight*2);
			}
		}
//		System.out.println(cGraph.maxLength);
	}
}
