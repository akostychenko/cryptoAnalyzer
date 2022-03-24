package ru.javarush.akostychenko.cryptoanalyzer.controllers;

import ru.javarush.akostychenko.cryptoanalyzer.commands.Action;
import ru.javarush.akostychenko.cryptoanalyzer.commands.Bruteforce;
import ru.javarush.akostychenko.cryptoanalyzer.commands.Decoder;
import ru.javarush.akostychenko.cryptoanalyzer.commands.Encoder;
import ru.javarush.akostychenko.cryptoanalyzer.exceptions.AppException;

public enum ActionFactory {
    ENCODE( new Encoder() ),
    DECODE( new Decoder() ),
    BRUTE(new Bruteforce() );


    private final Action action;

    ActionFactory(Action action) {
        this.action = action;
    }

    public static Action get(String actionName) {
        try {
            ActionFactory value = ActionFactory.valueOf( actionName.toUpperCase() );
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException( "not found " + actionName, e );
        }
    }
}
