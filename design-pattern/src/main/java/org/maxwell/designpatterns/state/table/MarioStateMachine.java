package org.maxwell.designpatterns.state.table;

import org.maxwell.designpatterns.state.batch.State;

import static org.maxwell.designpatterns.state.batch.State.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/18 16:44
 */
public class MarioStateMachine {

    private static final State[][] TRANSITION_TABLE = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}
    };

    private static final int[][] ACTION_TABLE = {
            {100, 200, 300, 0},
            {0, 200, 300, -100},
            {0, 0, 0, -200},
            {0, 0, 0, -300},
    };

    private int score;
    private State currentState;

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }


    public void obtainMushRoom() {
        executeEvent(Event.GET_MUSHROOM);
    }

    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = TRANSITION_TABLE[stateValue][eventValue];
        this.score += ACTION_TABLE[stateValue][eventValue];
    }


}
