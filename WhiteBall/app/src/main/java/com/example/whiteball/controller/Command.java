package com.example.whiteball.controller;

/**
 * A command instance.
 */
public class Command {
    private CommandType commandType;
    private float commandValue;

    public Command(final CommandType commandType, final float commandValue) {
        this.commandType = commandType;
        this.commandValue = commandValue;
    }

    /**
     *
     * @return the {@link CommandType} of the command.
     */
    public CommandType getType() {
        return this.commandType;
    }

    /**
     *
     * @return the value of the command.
     */
    public float getValue() {
        return this.commandValue;
    }
}
