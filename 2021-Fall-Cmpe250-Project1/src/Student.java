public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private double duration;
	private double rating;
	
	public Student(int id, String name, double duration, double rating) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.rating = rating;
	}
	
	@Override
	public int compareTo(Student e) {
		return (int)(this.getId()-e.getId());
	}
	
	public void decreaseDuration() {
		this.setDuration(this.getDuration()-1);
	}
	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	
	
}
