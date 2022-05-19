public class House implements Comparable<House> {
	private int id;
	private double duration;
	private double rating;
	
	public House(int id, double duration, double rating) {
		this.id = id;
		this.duration = duration;
		this.rating = rating;
	}
	
	@Override
	public int compareTo(House e) {
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
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	
	
}
