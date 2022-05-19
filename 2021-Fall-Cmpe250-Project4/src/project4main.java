import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class project4main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		
		ArrayList<Vertex> greenTrains = new ArrayList<Vertex>();
		ArrayList<Vertex> redTrains = new ArrayList<Vertex>();
		ArrayList<Vertex> greenReindeers = new ArrayList<Vertex>();
		ArrayList<Vertex> redReindeers = new ArrayList<Vertex>();
		
		ArrayList<Vertex> Trains = new ArrayList<Vertex>();
		ArrayList<Vertex> Reindeers = new ArrayList<Vertex>();

		ArrayList<Vertex> greenVehicles = new ArrayList<Vertex>();
		ArrayList<Vertex> redVehicles = new ArrayList<Vertex>();
		
		ArrayList<Vertex> allVehicles = new ArrayList<Vertex>();
		
		ArrayList<Vertex> allVertex = new ArrayList<Vertex>();

		HashMap<Edge,Edge> reverseEdges = new HashMap<Edge,Edge>();
		
		Vertex source = new Vertex(0);
		allVertex.add(source);
		
		Vertex sink = new Vertex(1);
		allVertex.add(sink);
		int vertexID = 2;
		
		
		/*  The number of trains go to green region */
		int tGreen = Integer.parseInt(input.nextLine());
//		System.out.println(tGreen);
		if (tGreen != 0) {
			String[] inputSplitted = input.nextLine().split(" ");
			
			for(int a = 0; a < (inputSplitted.length) ; a++) {
				int tempCap = Integer.parseInt(inputSplitted[a]);
//				System.out.println(tempCap);
				Vertex greenTrain = new Vertex(vertexID);
				allVertex.add(greenTrain);
				
				Edge gTrainSink = new Edge(greenTrain,sink,tempCap,0);
				greenTrain.addAdj(gTrainSink);
				sink.addAdj(gTrainSink);
				Edge reverseEdge = new Edge(sink,greenTrain,0,0);
				greenTrain.addAdj(reverseEdge);
				sink.addAdj(reverseEdge);
				reverseEdges.put(gTrainSink, reverseEdge);
				reverseEdges.put(reverseEdge, gTrainSink);

				greenTrains.add(greenTrain);
				Trains.add(greenTrain);
				allVehicles.add(greenTrain);
				greenVehicles.add(greenTrain);
				vertexID += 1;
			}
		}
		else {
			String temp = input.nextLine();
			int tCapacityGreen = 0;
//			System.out.println(tCapacityGreen);
		}
		
		
		/*  The number of trains go to red region */
		int tRed = Integer.parseInt(input.nextLine());
//		System.out.println(tRed);
		if (tRed != 0) {
			String[] inputSplitted = input.nextLine().split(" ");
			
			for(int a = 0; a < (inputSplitted.length) ; a++) {
				int tempCap = Integer.parseInt(inputSplitted[a]);
//				System.out.println(tempCap);

				Vertex redTrain = new Vertex(vertexID);
				allVertex.add(redTrain);
				Edge rTrainSink = new Edge(redTrain,sink,tempCap,0);
				redTrain.addAdj(rTrainSink);
				sink.addAdj(rTrainSink);
				Edge reverseEdge = new Edge(sink,redTrain,0,0);
				redTrain.addAdj(reverseEdge);
				sink.addAdj(reverseEdge);
				reverseEdges.put(rTrainSink, reverseEdge);
				reverseEdges.put(reverseEdge, rTrainSink);

				redTrains.add(redTrain);
				Trains.add(redTrain);
				allVehicles.add(redTrain);
				redVehicles.add(redTrain);
				vertexID += 1;
			}
		}
		else {
			String temp = input.nextLine();
			int tCapacityRed = 0;
//			System.out.println(tCapacityRed);
		}
		
		
		/*  The number of reindeers go to green region */
		int rGreen = Integer.parseInt(input.nextLine());
//		System.out.println(rGreen);
		if (rGreen != 0) {
			String[] inputSplitted = input.nextLine().split(" ");
			
			for(int a = 0; a < (inputSplitted.length) ; a++) {
				int tempCap = Integer.parseInt(inputSplitted[a]);
				
//				System.out.println(tempCap);
				Vertex greenReindeer = new Vertex(vertexID);
				allVertex.add(greenReindeer);
				Edge gReindeerSink = new Edge(greenReindeer,sink,tempCap,0);
				greenReindeer.addAdj(gReindeerSink);
				sink.addAdj(gReindeerSink);
				Edge reverseEdge = new Edge(sink,greenReindeer,0,0);
				greenReindeer.addAdj(reverseEdge);
				sink.addAdj(reverseEdge);
				reverseEdges.put(gReindeerSink, reverseEdge);
				reverseEdges.put(reverseEdge, gReindeerSink);

				greenReindeers.add(greenReindeer);
				Reindeers.add(greenReindeer);
				allVehicles.add(greenReindeer);
				greenVehicles.add(greenReindeer);
				vertexID += 1;
			}
		}
		else {
			String temp = input.nextLine();
			int rCapacityGreen = 0;
//			System.out.println(rCapacityGreen);
		}
		
		
		/*  The number of reindeers go to red region */
		int rRed = Integer.parseInt(input.nextLine());
//		System.out.println(rRed);
		if (rRed != 0) {
			String[] inputSplitted = input.nextLine().split(" ");
			
			for(int a = 0; a < (inputSplitted.length) ; a++) {
				int tempCap = Integer.parseInt(inputSplitted[a]);

//				System.out.println(tempCap);
				Vertex redReindeer = new Vertex(vertexID);
				allVertex.add(redReindeer);
				Edge rReindeerSink = new Edge(redReindeer,sink,tempCap,0);
				redReindeer.addAdj(rReindeerSink);
				sink.addAdj(rReindeerSink);
				Edge reverseEdge = new Edge(sink,redReindeer,0,0);
				redReindeer.addAdj(reverseEdge);
				sink.addAdj(reverseEdge);
				reverseEdges.put(rReindeerSink, reverseEdge);
				reverseEdges.put(reverseEdge, rReindeerSink);

				redReindeers.add(redReindeer);
				Reindeers.add(redReindeer);
				allVehicles.add(redReindeer);
				redVehicles.add(redReindeer);
				vertexID += 1;
			}
		}
		else {
			String temp = input.nextLine();
			int rCapacityRed = 0;
//			System.out.println(rCapacityRed);
		}
		int giftCount = 0;
		/* The number of gift types i.e number of bags */
		int numberOfBags = Integer.parseInt(input.nextLine());
		String typesAndNumbers = input.nextLine();
		String[] typesAndNumberList = typesAndNumbers.split(" ");
		int tempNum = 0;
		int x = 1;
		for(;tempNum < numberOfBags*2;) {

			String bagType = typesAndNumberList[tempNum];
			int numOfGifts = Integer.parseInt(typesAndNumberList[tempNum+1]);
//			System.out.println(bagType + " "+ numOfGifts);
			giftCount += numOfGifts;
			if(bagType.equals("a")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				
				for (Vertex vehicle: allVehicles) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);


				}
			}
			else if (bagType.equals("b")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: greenVehicles) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);


				}
			}
			else if (bagType.equals("c")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: redVehicles) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("d")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: Trains) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);
				}
			}
			else if (bagType.equals("e")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: Reindeers) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);


				}
			}
			else if (bagType.equals("ab")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: greenVehicles) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("ac")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: redVehicles) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("ad")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: Trains) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("ae")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);
				for (Vertex vehicle: Reindeers) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("bd")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: greenTrains) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("be")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: greenReindeers) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("cd")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);

				for (Vertex vehicle: redTrains) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);


				}
			}
			else if (bagType.equals("ce")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: redReindeers) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,numOfGifts,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else if (bagType.equals("abd")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);
				for (Vertex vehicle: greenTrains) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);


				}
			}
			else if (bagType.equals("abe")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: greenReindeers) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);


				}
			}
			else if (bagType.equals("acd")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: redTrains) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);


				}
			}
			else if (bagType.equals("ace")) {
				Vertex giftVertex = new Vertex(vertexID);
				allVertex.add(giftVertex);
				vertexID += 1;
				
				Edge sourceGiftBagEdge = new Edge(source,giftVertex,numOfGifts,0);
				source.addAdj(sourceGiftBagEdge);
				giftVertex.addAdj(sourceGiftBagEdge);
				Edge reverseEdge = new Edge(giftVertex ,source ,0,0);
				source.addAdj(reverseEdge);
				giftVertex.addAdj(reverseEdge);
				reverseEdges.put(sourceGiftBagEdge , reverseEdge);
				reverseEdges.put(reverseEdge, sourceGiftBagEdge);

				for (Vertex vehicle: redReindeers) {
					Edge sinkGiftBagEdge = new Edge(giftVertex,vehicle,1,0);
					giftVertex.addAdj(sinkGiftBagEdge);
					vehicle.addAdj(sinkGiftBagEdge);
					Edge reverseEdgee = new Edge( vehicle,giftVertex ,0,0);
					giftVertex.addAdj(reverseEdgee);
					vehicle.addAdj(reverseEdgee);
					reverseEdges.put( sinkGiftBagEdge, reverseEdgee);
					reverseEdges.put(reverseEdgee, sinkGiftBagEdge);

				}
			}
			else {
				System.out.println("invalid");
			}
			tempNum += 2;
		}
		Graph graph = new Graph(allVertex,reverseEdges);
//		for(Edge edge :allEdges) {
//			System.out.println(edge.from.id +" "+ edge.to.id);
//		}
//		for(Vertex a : allVertex) {
//			System.out.print(a.id + " ");
//		}
//		System.out.println();
		out.print(giftCount-Algorithm.maxFlow(graph, source.id, sink.id));
	}
}
