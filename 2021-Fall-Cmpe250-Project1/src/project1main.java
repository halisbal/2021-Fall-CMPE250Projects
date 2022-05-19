import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class project1main {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));
		
		PriorityQueue<Student> Students = new PriorityQueue<Student>();
		PriorityQueue<House> Houses = new PriorityQueue<House>();
		ArrayList<Student> studentArray = new ArrayList<Student>();
		
		PriorityQueue<Student> firstQueue = new PriorityQueue<Student>();

		while(input.hasNextLine()) {
			String inputLine = input.nextLine();
			
			if(inputLine.startsWith("h")) {
				String[] a1 = inputLine.split(" ");
				
				int houseId = Integer.parseInt(a1[1]);
				double houseDuration = Double.parseDouble(a1[2]);
				double houseRating = Double.parseDouble(a1[3]);
				
				House newHouse = new House(houseId,houseDuration,houseRating);
				Houses.add(newHouse);
			}
			else if(inputLine.startsWith("s")) {
				String[] a2 = inputLine.split(" ");
				
				int studentId = Integer.parseInt(a2[1]);
				String studentName = a2[2];
				double studentDuration = Double.parseDouble(a2[3]);
				double studentRating = Double.parseDouble(a2[4]);
				
				if(studentDuration == 0) {
					Student newStudent = new Student(studentId,studentName,studentDuration,studentRating);
					firstQueue.add(newStudent);
				}
				else {
					Student newStudent = new Student(studentId,studentName,studentDuration,studentRating);
					Students.add(newStudent);
					firstQueue.add(newStudent);
				}
			}
		}
		while(!Students.isEmpty()) {
			PriorityQueue<Student> studentsCopy = new PriorityQueue<Student>(Students);
			while(!studentsCopy.isEmpty()){
				PriorityQueue<House> housesCopy = new PriorityQueue<House>(Houses);
			    Student student_obj = studentsCopy.poll();
			    double studentDuration = student_obj.getDuration();
			    while(!housesCopy.isEmpty()) {
			    	House house_obj = housesCopy.poll();
			    	Double house_duration = house_obj.getDuration();
			    	
			    	if((house_duration == 0) && (student_obj.getRating() <= house_obj.getRating())) {
			    		house_obj.setDuration(studentDuration);
			    		Students.remove(student_obj);
			    		studentArray.add(student_obj);
			    		break;
			    	}
			    }
			}
			PriorityQueue<Student> studentsCopy2 = new PriorityQueue<Student>(Students);
			PriorityQueue<House> housesCopy2 = new PriorityQueue<House>(Houses);
			while(!studentsCopy2.isEmpty()) {
				Student student = studentsCopy2.poll();
				student.decreaseDuration();
				if (student.getDuration() == 0) {
					Students.remove(student);
				}
			}
			while(!housesCopy2.isEmpty()) {
				House house = housesCopy2.poll();
				if (house.getDuration() != 0) {
					house.decreaseDuration();
				}
			}
		}
		ArrayList<String> lastArray = new ArrayList<String>();

		for (Student student : studentArray) {
			lastArray.add(student.getName());
		}
		while(!firstQueue.isEmpty()) {
			Student student = firstQueue.poll();
			if(!lastArray.contains(student.getName())) {
				output.println(student.getName());
			}
		}
	}
}
