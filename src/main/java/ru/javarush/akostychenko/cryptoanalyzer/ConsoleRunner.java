package ru.javarush.akostychenko.cryptoanalyzer;

import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}