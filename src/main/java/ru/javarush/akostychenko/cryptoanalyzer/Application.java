package ru.javarush.akostychenko.cryptoanalyzer;

import ru.javarush.akostychenko.cryptoanalyzer.controllers.MainController;
import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;
import ru.javarush.akostychenko.cryptoanalyzer.exceptions.AppException;

import java.util.Arrays;

public class Application {
    private final MainController mainController;
    public Application(){
mainController = new MainController();

    }

    public Result run(String[] args) {
        if (args.length>0){
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            Result result = mainController.doAction(action, parameters);
        }

        throw new AppException();
    }
}
