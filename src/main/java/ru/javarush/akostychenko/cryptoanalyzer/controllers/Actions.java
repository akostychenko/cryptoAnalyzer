package ru.javarush.akostychenko.cryptoanalyzer.controllers;

import ru.javarush.akostychenko.cryptoanalyzer.commands.Action;
import ru.javarush.akostychenko.cryptoanalyzer.commands.Decoder;
import ru.javarush.akostychenko.cryptoanalyzer.commands.Encoder;
import ru.javarush.akostychenko.cryptoanalyzer.exceptions.AppException;

import java.util.Locale;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());
    private final Action action;

    Actions(Action action) {

        this.action = action;
    }
    public static Action find(String actionName){
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e){
            throw new AppException("Not found " + actionName, e);
        }
    }
}
