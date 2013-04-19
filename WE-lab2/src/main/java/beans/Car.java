/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author gruppe 33
 */
public class Car {
    private int fieldId, userId;
	
	public Car(int fieldId, int userId) {
		this.fieldId = fieldId;
		this.userId = userId;
	}

	/**
	 * @return the fieldId
	 */
	public int getFieldId() {
		return fieldId;
	}

	/**
	 * @param fieldId the fieldId to set
	 */
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the playerId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
