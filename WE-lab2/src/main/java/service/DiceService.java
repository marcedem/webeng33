/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Dice;

/**
 *
 * @author gruppe 33
 */
public class DiceService {

    private Dice playerDice;
    private Dice computerDice;

    public DiceService() {
        this.playerDice = new Dice();
        this.computerDice = new Dice();
        
    }

    /**
     * rolls the player's dice
     */
    public void rollPlayerDice() {
        this.getPlayerDice().rollDice();
    }

    /**
     * rolls the computer's dice
     */
    public void rollComputerDice() {
        this.getComputerDice().rollDice();
        
    }

    /**
     * @return the playerDice
     */
    public Dice getPlayerDice() {
        return playerDice;
    }

    /**
     * @param playerDice the playerDice to set
     */
    public void setPlayerDice(Dice playerDice) {
        this.playerDice = playerDice;
    }

    /**
     * @return the computerDice
     */
    public Dice getComputerDice() {
        return computerDice;
    }

    /**
     * @param computerDice the computerDice to set
     */
    public void setComputerDice(Dice computerDice) {
        this.computerDice = computerDice;
    }
    
    
}
