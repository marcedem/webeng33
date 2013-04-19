/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 * 
 * @author gruppe 33
 *
 */
public class Field {

	private int fieldId, home, first, last, win, playerId;
	private String imgPath, descript, baseDescript;
	private User user;

	public Field(int fieldId) {
		this.fieldId = fieldId;
		this.home = 0;
		this.first = 0;
		this.last = 0;
		this.win = 0;
		this.playerId = 0;
		this.imgPath = "img/field.png";
		this.descript = "Feld " + this.fieldId;
		this.baseDescript = this.descript;
		this.user = null;
	}

	public Field(int fieldId, int start, int first, int last, int win,
			int playerId, String imgPath, String descript, String baseDescript,
			User user) {
		this.fieldId = fieldId;
		this.home = start;
		this.first = first;
		this.last = last;
		this.win = win;
		this.playerId = playerId;
		this.imgPath = imgPath;
		this.descript = descript;
		this.baseDescript = baseDescript;
		this.user = user;
	}

	/**
	 * @return the fieldId
	 */
	public int getFieldId() {
		return fieldId;
	}

	/**
	 * @param fieldId
	 *            the fieldId to set
	 */
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	/**
	 * @return the home
	 */
	public int getHome() {
		return home;
	}

	/**
	 * @param home
	 *            the home to set
	 */
	public void setHome(int home) {
		this.home = home;
	}

	/**
	 * @return the first
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * @param first
	 *            the first to set
	 */
	public void setFirst(int first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public int getLast() {
		return last;
	}

	/**
	 * @param last
	 *            the last to set
	 */
	public void setLast(int last) {
		this.last = last;
	}

	/**
	 * @return the win
	 */
	public int getWin() {
		return win;
	}

	/**
	 * @param win
	 *            the win to set
	 */
	public void setWin(int win) {
		this.win = win;
	}

	/**
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId
	 *            the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath
	 *            the imgPath to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * @return the descript
	 */
	public String getDescript() {
		return descript;
	}

	/**
	 * @param descript
	 *            the descript to set
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}

	/**
	 * @return the baseDescript
	 */
	public String getBaseDescript() {
		return baseDescript;
	}

	/**
	 * @param baseDescript
	 *            the baseDescript to set
	 */
	public void setBaseDescript(String baseDescript) {
		this.baseDescript = baseDescript;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the player to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}