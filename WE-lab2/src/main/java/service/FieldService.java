/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Car;
import beans.Field;
import java.util.HashMap;

/**
 *
 * @author alex
 */
public class FieldService {

    private HashMap<Integer, Field> raceTrack;
    private Car player;
    private Car computer;

    public FieldService() {
        this.raceTrack = new HashMap<Integer, Field>();

        for (int i = 1; i <= 7; i++) {
            raceTrack.put(i, new Field(i));
        }
        
        this.initRaceTrack();

    }
    
    private void initRaceTrack() {
        this.initStart();
        this.initFinish();
        this.initEmptyFields();
        this.initOilFields();
    }
    
    private void initStart() {

        this.raceTrack.get(1).setStart(true);
        this.raceTrack.get(1).setBaseDescription(
                "Feld " + 1 + ": Start");
        this.raceTrack.get(1).setImgPath("img/start_road.png");
        this.raceTrack.get(1).setDescription("Feld " + 1 + ": Start");

    }

    private void initFinish() {

        this.raceTrack.get(7).setFinish(true);
        this.raceTrack.get(7).setBaseDescription(
                "Feld " + 7 + ": Zielfeld");
        this.raceTrack.get(7).setImgPath("img/finish_road.png");
        this.raceTrack.get(7).setDescription("Feld " + 7 + ": Zielfeld");

    }

    private void initEmptyFields() {

        this.raceTrack.get(2).setImgPath("img/empty_road.png");
        this.raceTrack.get(2).setBaseDescription(
                "Feld " + 2 + ": Leere Strasse");
        this.raceTrack.get(2).setDescription("Feld " + 2 + ": Leere Strasse");

        this.raceTrack.get(4).setImgPath("img/empty_road.png");
        this.raceTrack.get(4).setBaseDescription(
                "Feld " + 4 + ": Leere Straße");
        this.raceTrack.get(4).setDescription("Feld " + 4 + ": Leere Strasse");

        this.raceTrack.get(5).setImgPath("img/empty_road.png");
        this.raceTrack.get(5).setBaseDescription(
                "Feld " + 5 + ": Leere Straße");
        this.raceTrack.get(5).setDescription("Feld " + 5 + ": Leere Strasse");

    }

    private void initOilFields() {

        this.raceTrack.get(3).setOil(true);
        this.raceTrack.get(3).setImgPath("img/oil_road.png");
        this.raceTrack.get(3).setBaseDescription(
                "Feld " + 3 + ": Oelfeld");
        this.raceTrack.get(3).setDescription("Feld " + 3 + ": Oelfeld");

        this.raceTrack.get(6).setOil(true);
        this.raceTrack.get(6).setImgPath("img/oil_road.png");
        this.raceTrack.get(6).setBaseDescription(
                "Feld " + 6 + ": Oelfeld");
        this.raceTrack.get(6).setDescription("Feld " + 6 + ": Oelfeld");
    }

    /**
     * @return the raceTrack
     */
    public HashMap<Integer, Field> getRaceTrack() {
        return raceTrack;
    }

    /**
     * @param raceTrack the raceTrack to set
     */
    public void setRaceTrack(HashMap<Integer, Field> raceTrack) {
        this.raceTrack = raceTrack;
    }

    /**
     * @return the player
     */
    public Car getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Car player) {
        this.player = player;
    }

    /**
     * @return the computer
     */
    public Car getComputer() {
        return computer;
    }

    /**
     * @param computer the computer to set
     */
    public void setComputer(Car computer) {
        this.computer = computer;
    }
}
