package com.example.whiteball.controller;

/**
 * An observable that triggers the {@link InputObserver} when a {@link Command} is detected.
 */
public interface InputObservable {
    /**
     * Adds an {@link InputObserver} to the observer's list.
     * @param observer
     */
    void addObserver(InputObserver observer);

    /**
     * Removes the specified {@link InputObserver} to the observer's list.
     * @param observer
     */
    void removeObserver(InputObserver observer);

    /**
     * Triggers the {@link InputObserver} when a {@link Command} is detected.
     * @param command the {@link Command} detected.
     */
    void notifyObservers(Command command);
}
