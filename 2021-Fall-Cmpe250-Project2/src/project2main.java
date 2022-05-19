
import java.io.FileNotFoundException;  
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class project2main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		Map<Integer, Integer> currentPlayersAndCoachs = new HashMap<Integer, Integer>();
		double currentTime = 0;
		ArrayList<Player> playerArray = new ArrayList<Player>();
		ArrayList<Trainer> trainerArray = new ArrayList<Trainer>();
		ArrayList<Masseur> masseurArray = new ArrayList<Masseur>();
		ArrayList<Physiotherapist> physiotherapistArray = new ArrayList<Physiotherapist>();
		
		int maxTrainingQueueLength = 0;
		int maxMassageQueueLength = 0;
		int maxPhysiotherapyQueueLength = 0;
		ArrayList<Double> output10data = new ArrayList<Double>();
		ArrayList<Double> trainingTime = new ArrayList<Double>();
		ArrayList<Double> massageTime = new ArrayList<Double>();
		ArrayList<Double> physiotherapyTime = new ArrayList<Double>();
		
		ArrayList<Double> trainingQueueTime = new ArrayList<Double>();
		ArrayList<Double> massageQueueTime = new ArrayList<Double>();
		ArrayList<Double> physiotherapyQueueTime = new ArrayList<Double>();

		PriorityQueue<Player> trainingQueue = new PriorityQueue<Player>(new PlayerTrainingComparator());
		PriorityQueue<Player> massageQueue = new PriorityQueue<Player>(new PlayerMassageComparator());
		PriorityQueue<Player> physiotherapyQueue = new PriorityQueue<Player>(new PlayerPhysiotherapyComparator());
		PriorityQueue<Event> events = new PriorityQueue<Event>();
		PriorityQueue<Trainer> trainerQueue = new PriorityQueue<Trainer>();
		PriorityQueue<Masseur> masseurQueue = new PriorityQueue<Masseur>();
		PriorityQueue<Physiotherapist> physiotherapistQueue = new PriorityQueue<Physiotherapist>();


		int numberOfPlayers = Integer.parseInt(input.nextLine());
		/** creating player objects */
		for(int a = 0 ; a<numberOfPlayers ; a++) {
			String inputLine = input.nextLine();
			String[] a1 = inputLine.split(" ");
			Player newPlayer = new Player(Integer.parseInt(a1[0]),Integer.parseInt(a1[1]));
			playerArray.add(newPlayer);
		}
		int numberOfArrivals = Integer.parseInt(input.nextLine());
		/** creating initial event objects */
		for(int a = 0 ; a<numberOfArrivals ; a++) {
			String inputLine = input.nextLine();
			String[] a2 = inputLine.split(" ");
			if (inputLine.startsWith("t")) {
				Event newEvent = new Event("t",Double.parseDouble(a2[2]), Double.parseDouble(a2[3]),playerArray.get(Integer.parseInt(a2[1])));
				events.add(newEvent);
			}
			else if (inputLine.startsWith("m")) {
				Event newEvent = new Event("m",Double.parseDouble(a2[2]), Double.parseDouble(a2[3]),playerArray.get(Integer.parseInt(a2[1])));
				events.add(newEvent);
			}
			else {
				System.out.println("hata");
			}
		}
		/** creating physiotherapist objects */
		String physioLine = input.nextLine();
		String[] a3 = physioLine.split(" ");
		for(int a = 0 ; a<Integer.parseInt(a3[0]) ; a++) {
			Physiotherapist newPhysiotherapist = new Physiotherapist(a,Double.parseDouble(a3[a+1]));
			physiotherapistQueue.add(newPhysiotherapist);
			physiotherapistArray.add(newPhysiotherapist);
		}
		
		String nextLine = input.nextLine();
		String[] a4 = nextLine.split(" ");		
		int numberOfTrainers = Integer.parseInt(a4[0]);
		int numberOfMasseurs = Integer.parseInt(a4[1]);
		/** creating trainer objects */

		for(int a = 0 ; a<numberOfTrainers ; a++) {
			Trainer newTrainer = new Trainer(a);
			trainerQueue.add(newTrainer);
			trainerArray.add(newTrainer);
		}
		/** creating masseur objects */

		for(int a = 0 ; a<numberOfMasseurs ; a++) {
			Masseur newMasseur = new Masseur(a);
			masseurQueue.add(newMasseur);
			masseurArray.add(newMasseur);
		}
		/** executing events when event queue is not empty */

		while(events.size()>0) {
			Event currentEvent = events.poll();
			currentTime = currentEvent.eventTime;
			Player thisPlayer = currentEvent.player;
			/** training start event */

			if (currentEvent.eventType.equals("t")) {
				boolean b1 = thisPlayer.isAvailable();
				
				if (b1) {
					thisPlayer.setTrainingArrivalTime(currentTime);
					thisPlayer.setCurrentTrainingTime(currentEvent.eventDuration);
					trainingQueue.add(thisPlayer);
					thisPlayer.makeUnavailable();
//					System.out.print("Training Queue Arriving Player ID: ");
//					System.out.print(thisPlayer.getId());
//					System.out.print("time: ");
//					System.out.println(currentTime);
				}
				else {
					thisPlayer.increaseNumberOfCanceledAttempts();
				}
			}
			/** massage start event */

			else if (currentEvent.eventType.equals("m")) {
				boolean b1 = thisPlayer.isAvailable();
				
				if (b1 && thisPlayer.getMassageCount() < 3) {
					thisPlayer.setMassageArrivalTime(currentTime);
					massageQueue.add(thisPlayer);
					thisPlayer.increaseMassageCount();
					thisPlayer.makeUnavailable();
					thisPlayer.setCurrentMassageTime(currentEvent.eventDuration);
				}
				else if(thisPlayer.getMassageCount() == 3) {
					thisPlayer.increaseNumberOfInvalidAttempts();
				}
				else {
					thisPlayer.increaseNumberOfCanceledAttempts();
				}
			}
			/** training leave event */

			else if (currentEvent.eventType.equals("tleave")) {
				double cTrainingTime = thisPlayer.getCurrentTrainingTime();
				trainingTime.add(cTrainingTime);
				thisPlayer.setLastTrainingTime(cTrainingTime);
				trainerQueue.add(trainerArray.get(currentPlayersAndCoachs.get(thisPlayer.getId())));
				currentPlayersAndCoachs.remove(thisPlayer.getId());
				physiotherapyQueue.add(thisPlayer);
				thisPlayer.setPhysiotherapyArrivalTime(currentTime);
//				System.out.print("Physio Queue Arriving Player ID: ");
//				System.out.print(thisPlayer.getId());
//				System.out.print("time: ");
//				System.out.println(currentTime);
			}
			/** massage leave event  */

			else if (currentEvent.eventType.equals("mleave")) {
				double cMassageTime = thisPlayer.getCurrentMassageTime();
				massageTime.add(cMassageTime);
				thisPlayer.makeAvailable();
				masseurQueue.add(masseurArray.get(currentPlayersAndCoachs.get(thisPlayer.getId())));
				currentPlayersAndCoachs.remove(thisPlayer.getId());
			}
			/** physiotherapy leave event */

			else if (currentEvent.eventType.equals("pleave")) {
				double cPhysioTime = thisPlayer.getCurrentPhysiotherapyTime();
				physiotherapyTime.add(cPhysioTime);
				thisPlayer.makeAvailable();
				physiotherapistQueue.add(physiotherapistArray.get(currentPlayersAndCoachs.get(thisPlayer.getId())));
				currentPlayersAndCoachs.remove(thisPlayer.getId());
				output10data.add(currentTime - thisPlayer.getTrainingArrivalTime()); 
			}
			/** training queue leaving/starting training event */

			while(trainingQueue.size()>0 && trainerQueue.size()>0) {
				Player currentPlayer = trainingQueue.poll();
				trainingQueueTime.add(currentTime-currentPlayer.getTrainingArrivalTime());
				Trainer currentTrainer = trainerQueue.poll();
				currentPlayersAndCoachs.put(currentPlayer.getId(),currentTrainer.id);
				
				Event newEvent = new Event("tleave",currentTime+currentPlayer.getCurrentTrainingTime(),0,currentPlayer);
				events.add(newEvent);
			}
			/**  massage queue leaving/starting massage event */

			while(massageQueue.size()>0 && masseurQueue.size()>0) {
				Player currentPlayer = massageQueue.poll();
				massageQueueTime.add(currentTime-currentPlayer.getMassageArrivalTime());
				currentPlayer.setTotalMassageQueueTime(currentPlayer.getTotalMassageQueueTime()+currentTime-currentPlayer.getMassageArrivalTime());
				Masseur currentMasseur = masseurQueue.poll();
				currentPlayersAndCoachs.put(currentPlayer.getId(), currentMasseur.id);
				
				Event newEvent = new Event("mleave",currentTime+currentPlayer.getCurrentMassageTime(),0,currentPlayer);
				events.add(newEvent);
			}
			/** physiotherapy queue leaving/starting physiotherapy event */

			while(physiotherapyQueue.size()>0 && physiotherapistQueue.size()>0) {
				Player currentPlayer = physiotherapyQueue.poll();
				physiotherapyQueueTime.add(currentTime-currentPlayer.getPhysiotherapyArrivalTime());
				currentPlayer.setTotalPhysiotherapyQueueTime(currentPlayer.getTotalPhysiotherapyQueueTime()+currentTime-currentPlayer.getPhysiotherapyArrivalTime());
//				System.out.print("Physio Queue Leaving Player ID: ");
//				System.out.print(currentPlayer.getId());
//				System.out.print("time: ");
//				System.out.println(currentTime);
				Physiotherapist currentPhysiotherapist = physiotherapistQueue.poll();
				currentPlayer.setCurrentPhysiotherapyTime(currentPhysiotherapist.serviceTime);
				currentPlayersAndCoachs.put(currentPlayer.getId(), currentPhysiotherapist.id);
				
				Event newEvent = new Event("pleave",currentTime+currentPhysiotherapist.serviceTime,0,currentPlayer);
				events.add(newEvent);
			}
			if (trainingQueue.size() > maxTrainingQueueLength) {
				maxTrainingQueueLength = trainingQueue.size();
			}
			if (massageQueue.size() > maxMassageQueueLength) {
				maxMassageQueueLength = massageQueue.size();
			}
			if (physiotherapyQueue.size() > maxPhysiotherapyQueueLength) {
				maxPhysiotherapyQueueLength = physiotherapyQueue.size();
			}
		}
		/** writing necessary output data */

		out.println(maxTrainingQueueLength);
		out.println(maxPhysiotherapyQueueLength);
		out.println(maxMassageQueueLength);
		
	    Double averageTrainingQueueTime = trainingQueueTime.stream().mapToDouble(val -> val).average().orElse(0.0);
	    out.printf("%.3f",averageTrainingQueueTime);
	    out.println();
	    
	    Double averagePhysiotherapyQueueTime = physiotherapyQueueTime.stream().mapToDouble(val -> val).average().orElse(0.0);
	    out.printf("%.3f",averagePhysiotherapyQueueTime);
	    out.println();
	    
	    Double averageMassageQueueTime = massageQueueTime.stream().mapToDouble(val -> val).average().orElse(0.0);
	    out.printf("%.3f",averageMassageQueueTime);
	    out.println();
		
	    Double averageTrainingTime = trainingTime.stream().mapToDouble(val -> val).average().orElse(0.0);
	    out.printf("%.3f",averageTrainingTime);
	    out.println();
	    
	    Double averagePhysiotherapyTime = physiotherapyTime.stream().mapToDouble(val -> val).average().orElse(0.0);
	    out.printf("%.3f",averagePhysiotherapyTime);
	    out.println();
	    
	    Double averageMassageTime = massageTime.stream().mapToDouble(val -> val).average().orElse(0.0);
	    out.printf("%.3f",averageMassageTime);
	    out.println();
	    Double output10 = output10data.stream().mapToDouble(val -> val).average().orElse(0.0);
	    out.printf("%.3f",output10);
	    out.println();	    
	    Double maxPhysioTime = 0.0;
	    int maxId = 0;
	    for(Player player:playerArray) {
	    	Double physioTime = player.getTotalPhysiotherapyQueueTime();
	    	if (physioTime>maxPhysioTime) {
	    		maxPhysioTime = physioTime;
	    		maxId = player.getId();
	    	}
	    	else if (Math.abs(physioTime - maxPhysioTime) < 0.0000000001) {
	    		if(player.getId() < maxId) {
		    		maxId = player.getId();
	    		}
	    	}
	    }
	    out.print(maxId);
	    out.print(" ");
	    out.printf("%.3f",maxPhysioTime);
	    out.println();

	    
	    Double minMassageTime = 99999.99;
	    int minId = -1;
	    
	    for(Player player:playerArray) {
	    	Double massageTimee = player.getTotalMassageQueueTime();
	    	int massageCount = player.getMassageCount();
	    	if(massageCount == 3 && massageTimee < minMassageTime) {
	    		minMassageTime = massageTimee;
	    		minId = player.getId();
	    	}
	    	else if (Math.abs(minMassageTime - massageTimee) < 0.0000000001 && massageCount == 3) {
	    		if(player.getId() < minId) {
	    			minId = player.getId();
	    		}
	    	}
	    }
	    if(minMassageTime == 99999.99) {
	    	minMassageTime = -1.0;
	    }
	    out.print(minId);
	    out.print(" ");
	    out.printf("%.3f",minMassageTime);
	    out.println();
	    int invalidAttempts = 0;
	    for(Player player:playerArray) {
	    	invalidAttempts += player.getNumberOfInvalidAttempts();
	    }
	    out.println(invalidAttempts);
	    
	    int canceledAttempts = 0;
	    for(Player player:playerArray) {
	    	canceledAttempts += player.getNumberOfCanceledAttempts();
	    }
	    out.println(canceledAttempts);
	    out.printf("%.3f",currentTime);
	    out.println();
	}
}
