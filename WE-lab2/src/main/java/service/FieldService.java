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


    }
}
