/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author gruppe 33
 */
import java.util.Date;

public class TimerService {
	
	private long duration = 0;
	private Date startTime = null;
	
	public TimerService() {
	}
	
	/**
	 * starts the timer
	 */
	public void startTimer() {
		this.startTime = new Date();
	}
	
	/**
	 * updates the duration
	 */
	private void updateDuration() {
		if (this.startTime != null) {
			this.duration = new Date().getTime() - this.startTime.getTime();
		}
	}

	/**
	 * @return the formatted time
	 */
        @Override
	public String toString() {
		if (this.startTime != null) {
			this.updateDuration();
			long min = this.duration / 60000;
			long sec = (this.duration / 1000) % 60;
			return String.format("%s min, %s sec");
		}
		return (this.duration / 60000) + " : " + ((this.duration / 1000) % 60);
	}
	
	/**
	 * @return the duration
	 */
	public long getDuration() {
		if (this.startTime != null) {
			this.updateDuration();
			return duration / 1000;
		}
		return 0;
	}
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * @param startTime the statTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	

}
