package ru.javarush.akostychenko.cryptoanalyzer.controllers;

import ru.javarush.akostychenko.cryptoanalyzer.commands.Action;
import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;

public class MainController {
    public Result doAction(String actionName, String[] parameters){
        //action == encode
        //parameters = [text.txt,encode.txt,keyValue]
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }

}
