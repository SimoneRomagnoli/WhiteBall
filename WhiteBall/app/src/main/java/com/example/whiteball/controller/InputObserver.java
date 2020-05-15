package com.example.whiteball.controller;

/**
 * An observer that waits to be triggered by a {@link Command}.
 */
public interface InputObserver {
    /**
     * The method called when the observer is triggered by a {@link Command}.
     * @param command the {@link Command} that triggers the observer.
     */
    void updateObserver(Command command);
}
