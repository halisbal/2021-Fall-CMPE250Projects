

public class Player {
	private int id;
	private int skillLevel;
	
	private double trainingArrivalTime;
	private double massageArrivalTime;
	private double physiotherapyArrivalTime;
	
	private double lastTrainingTime;
	private double currentTrainingTime;
	private double currentMassageTime;
	private double currentPhysiotherapyTime;
	private double totalPhysiotherapyQueueTime;
	private double totalMassageQueueTime;
	
	private boolean isAvailable;
	private int massageCount;
	private int numberOfCanceledAttempts;
	private int numberOfInvalidAttempts;
	public Player(int id, int skillLevel) {
		this.id = id;
		this.skillLevel = skillLevel;
		
		this.trainingArrivalTime = 0;
		this.massageArrivalTime = 0;
		this.physiotherapyArrivalTime = 0;
		
		this.currentTrainingTime = 0;
		this.currentMassageTime = 0;
		this.currentPhysiotherapyTime = 0;
		
		this.lastTrainingTime = 0;
		this.isAvailable = true;
		this.massageCount = 0;
		this.numberOfInvalidAttempts=0;
		this.numberOfCanceledAttempts = 0;
		this.totalPhysiotherapyQueueTime = 0;
		this.totalMassageQueueTime = 0;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the skillLevel
	 */
	public int getSkillLevel() {
		return skillLevel;
	}
	

	/**
	 * @return the trainingArrivalTime
	 */
	public double getTrainingArrivalTime() {
		return trainingArrivalTime;
	}

	/**
	 * @param trainingArrivalTime the trainingArrivalTime to set
	 */
	public void setTrainingArrivalTime(double trainingArrivalTime) {
		this.trainingArrivalTime = trainingArrivalTime;
	}
	public void increaseMassageCount() {
		this.massageCount += 1;
	}
	public void increaseNumberOfCanceledAttempts() {
		this.numberOfCanceledAttempts += 1;
	}
	public void increaseNumberOfInvalidAttempts() {
		this.numberOfInvalidAttempts += 1;
	}
	/**
	 * @return the massageArrivalTime
	 */
	public double getMassageArrivalTime() {
		return massageArrivalTime;
	}

	/**
	 * @param massageArrivalTime the massageArrivalTime to set
	 */
	public void setMassageArrivalTime(double massageArrivalTime) {
		this.massageArrivalTime = massageArrivalTime;
	}

	/**
	 * @return the physiotherapyArrivalTime
	 */
	public double getPhysiotherapyArrivalTime() {
		return physiotherapyArrivalTime;
	}

	/**
	 * @param physiotherapyArrivalTime the physiotherapyArrivalTime to set
	 */
	public void setPhysiotherapyArrivalTime(double physiotherapyArrivalTime) {
		this.physiotherapyArrivalTime = physiotherapyArrivalTime;
	}

	/**
	 * @return the lastTrainingTime
	 */
	public double getLastTrainingTime() {
		return lastTrainingTime;
	}

	/**
	 * @param lastTrainingTime the lastTrainingTime to set
	 */
	public void setLastTrainingTime(double lastTrainingTime) {
		this.lastTrainingTime = lastTrainingTime;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void makeAvailable() {
		this.isAvailable = true;
	}
	
	public void makeUnavailable() {
		this.isAvailable = false;
	}

	/**
	 * @return the massageAttempt
	 */
	public int getMassageCount() {
		return massageCount;
	}

	/**
	 * @return the numberOfCanceledAttempts
	 */
	public int getNumberOfCanceledAttempts() {
		return numberOfCanceledAttempts;
	}

	/**
	 * @return the currentTrainingTime
	 */
	public double getCurrentTrainingTime() {
		return currentTrainingTime;
	}

	/**
	 * @param currentTrainingTime the currentTrainingTime to set
	 */
	public void setCurrentTrainingTime(double currentTrainingTime) {
		this.currentTrainingTime = currentTrainingTime;
	}

	/**
	 * @return the currentMassageTime
	 */
	public double getCurrentMassageTime() {
		return currentMassageTime;
	}

	/**
	 * @param currentMassageTime the currentMassageTime to set
	 */
	public void setCurrentMassageTime(double currentMassageTime) {
		this.currentMassageTime = currentMassageTime;
	}

	/**
	 * @return the currentPhysiotherapyTime
	 */
	public double getCurrentPhysiotherapyTime() {
		return currentPhysiotherapyTime;
	}

	/**
	 * @param currentPhysiotherapyTime the currentPhysiotherapyTime to set
	 */
	public void setCurrentPhysiotherapyTime(double currentPhysiotherapyTime) {
		this.currentPhysiotherapyTime = currentPhysiotherapyTime;
	}

	/**
	 * @return the numberOfInvalidAttempts
	 */
	public int getNumberOfInvalidAttempts() {
		return numberOfInvalidAttempts;
	}

	/**
	 * @return the totalPhysiotherapyQueueTime
	 */
	public double getTotalPhysiotherapyQueueTime() {
		return totalPhysiotherapyQueueTime;
	}

	/**
	 * @param totalPhysiotherapyQueueTime the totalPhysiotherapyQueueTime to set
	 */
	public void setTotalPhysiotherapyQueueTime(double totalPhysiotherapyQueueTime) {
		this.totalPhysiotherapyQueueTime = totalPhysiotherapyQueueTime;
	}

	/**
	 * @return the totalMassageQueueTime
	 */
	public double getTotalMassageQueueTime() {
		return totalMassageQueueTime;
	}

	/**
	 * @param totalMassageQueueTime the totalMassageQueueTime to set
	 */
	public void setTotalMassageQueueTime(double totalMassageQueueTime) {
		this.totalMassageQueueTime = totalMassageQueueTime;
	}
	
	

}

