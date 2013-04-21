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

    private int fieldId, playerId;
    private boolean start, finish, oil;
    private String imgPath, description, baseDescription;
    private User user;

    public Field(int fieldId) {
        this.fieldId = fieldId;
        this.start = false;
        this.finish = false;
        this.oil = false;
        this.playerId = 0;
        this.imgPath = "img/empty_road.png";
        this.description = "Feld " + this.fieldId;
        this.baseDescription = this.description;
        this.user = null;
    }

    public Field(int fieldId, boolean start, boolean finish, boolean oil, int playerId, String imgPath, String description, String baseDescription,
            User user) {
        this.fieldId = fieldId;
        this.start = start;
        this.finish = finish;
        this.oil = oil;
        this.playerId = playerId;
        this.imgPath = imgPath;
        this.description = description;
        this.baseDescription = baseDescription;
        this.user = user;
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
     * @return the playerId
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * @param playerId the playerId to set
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * @return the start
     */
    public boolean isStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(boolean start) {
        this.start = start;
    }

    /**
     * @return the finish
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * @param finish the finish to set
     */
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    /**
     * @return the oil
     */
    public boolean isOil() {
        return oil;
    }

    /**
     * @param oil the oil to set
     */
    public void setOil(boolean oil) {
        this.oil = oil;
    }

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the baseDescription
     */
    public String getBaseDescription() {
        return baseDescription;
    }

    /**
     * @param baseDescription the baseDescription to set
     */
    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}