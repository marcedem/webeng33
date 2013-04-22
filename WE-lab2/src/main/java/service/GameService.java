/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.User;
import java.util.ArrayList;

/**
 *
 * @author gruppe 33
 */
public class GameService {

    private int playerCount = 0, round = 1;
    private User leader = null;
    private TimerService time = null;
    private String currentPlayer = new String();
    private ArrayList<User> users = new ArrayList<User>();
    private boolean initialized, playersTurn = true, gameOver;
    private DiceService diceService;
    private FieldService fieldService = new FieldService();

    public GameService() {
    }

    /**
     *
     * @param players
     * @return !initialized
     */
    public boolean init(ArrayList<User> users) {
        if (initialized) {
            return false;
        }

        this.users = users;
        this.playerCount = users.size();
        this.time = new TimerService();
        this.startGame();

        this.setInitialized(true);
        return true;
    }

    public void startGame() {
        this.time.startTimer();
        this.setCurrentPlayer(this.users.get(0).getName());
    }

    /**
     * rolls the player's dice
     *
     */
    public void rollPlayerDice() {
        this.getDiceService().rollPlayerDice();

        
            this.setPlayersTurn(!this.playersTurn);
            this.round++;
        

        if (this.getFieldService().moveCar(1, this.getDiceService().getPlayerDice().getRoll())) {
            // winner
            this.gameOver = true;
        }
        if (this.fieldService.getLeader() == 0) {
            this.leader = null;
        } else {
            this.leader = this.users.get(this.fieldService.getLeader() - 1);
        }
    }

    /**
     * rolls the computer's dice
     */
    public void rollComputerDice() {
        this.getDiceService().rollComputerDice();

        this.setPlayersTurn(true);
        

        if (this.getFieldService().moveCar(2, this.getDiceService().getComputerDice().getRoll())) {
            // winner
            this.gameOver = true;
        }
        if (this.fieldService.getLeader() == 0) {
            this.leader = null;
        } else {
            this.leader = this.users.get(this.fieldService.getLeader() - 1);
        }
    }

    /**
     * @return the initialized
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * @param initialized the initialized to set
     */
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    /**
     * @return the playersTurn
     */
    public boolean isPlayersTurn() {
        return playersTurn;
    }

    /**
     * @param playersTurn the playersTurn to set
     */
    public void setPlayersTurn(boolean playersTurn) {
        this.playersTurn = playersTurn;
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * @param gameOver the gameOver to set
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * @return the diceService
     */
    public DiceService getDiceService() {
        if (this.diceService == null) {
            this.diceService = new DiceService();
        }
        return diceService;
    }

    /**
     * @param diceService the diceService to set
     */
    public void setDiceService(DiceService diceService) {
        this.diceService = diceService;
    }

    /**
     * @return the playerCount
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * @param playerCount the playerCount to set
     */
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    /**
     * @return the leader
     */
    public User getLeader() {
        return leader;
    }

    /**
     * @param leader the leader to set
     */
    public void setLeader(User leader) {
        this.leader = leader;
    }

    /**
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * @return the time
     */
    public TimerService getTime() {
        if (this.time == null) {
            this.time = new TimerService();
        }
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(TimerService time) {
        this.time = time;
    }

    /**
     * @return the currentPlayer
     */
    public String getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * @return the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * @return the fieldService
     */
    public FieldService getFieldService() {
        return fieldService;
    }

    /**
     * @param fieldService the fieldService to set
     */
    public void setFieldService(FieldService fieldService) {
        this.fieldService = fieldService;
    }
}
