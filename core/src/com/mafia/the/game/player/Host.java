package com.mafia.the.game.player;

/**
 * Created by tb on 2/8/17.
 * Host class defines a game host character. Host should not be interfering with the game itself, but
 * it should know everything about the game including everyone's true identity, who killed who, etc.
 * For now, user should not be allowed to be a host. Perhaps later in the future.
 */

public class Host extends Player {

    public Host() {
        super();
    }

    public Host(String name, Boolean isAlive, Boolean isMafia) {
        super(name, isAlive, isMafia);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    /**
     * host should be alive until the game ends.
     */
    public Boolean isAlive() {
        return true;
    }

    @Override
    public Boolean mafiaFlag() {
        return false;
    }
}
