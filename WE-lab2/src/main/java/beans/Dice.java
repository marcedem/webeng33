/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.util.HashMap;
import java.util.Random;

/**
 * 
 * @author gruppe 33
 *
 */
public class Dice {

	private int roll;
	private int lastRoll;
	private HashMap<Integer, String> imgPath = new HashMap<Integer, String>();

	public Dice() {
		this.imgPath.put(0, "img/wuerfel0.png");
		this.imgPath.put(1, "img/wuerfel1.png");
		this.imgPath.put(2, "img/wuerfel2.png");
		this.imgPath.put(3, "img/wuerfel3.png");
		
	}
	
	public void rollDice() {
		this.setRoll(new Random().nextInt(3) + 1);
	}

	/**
	 * @return the roll
	 */
	public int getRoll() {
		return roll;
	}

	/**
	 * @param roll
	 *            the roll to set
	 */
	public void setRoll(int roll) {
		this.setLastRoll(this.roll);
		this.roll = roll;
	}

	/**
	 * @return the lastRoll
	 */
	public int getLastRoll() {
		return lastRoll;
	}

	/**
	 * @param lastRoll the lastRoll to set
	 */
	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}

	/**
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath.get(this.roll);
	}

}