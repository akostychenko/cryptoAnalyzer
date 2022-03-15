package ru.javarush.akostychenko.cryptoanalyzer.commands;

import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;

public interface Action {

    Result execute(String[] parameters);
}
