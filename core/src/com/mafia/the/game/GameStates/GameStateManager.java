package com.mafia.the.game.GameStates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;
/**
 * Created by tb on 2/3/17.
 */

public class GameStateManager {

        private Stack<State> states;

        public GameStateManager() {
            states = new Stack<State>();
        }

        public void push(State state){
            states.push(state);
        }

        public void pop(){
            states.pop().dispose();
        } //DISPOSE NOT USING STATES FOR MEMORY EFFICIENCY.

        //WHEN POPPING AND IMMEDIATELY PUSHING A STATE.
        public void set(State state){
            states.pop();
            states.push(state);
        }

        public void render(SpriteBatch sb){
            states.peek().render(sb);
        }

        public void update(float dt){
            //peek() is checking what's at the top element in the stack.
            states.peek().update(dt);
        }
}
