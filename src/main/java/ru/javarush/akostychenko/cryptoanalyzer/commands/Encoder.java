package ru.javarush.akostychenko.cryptoanalyzer.commands;

import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;
import ru.javarush.akostychenko.cryptoanalyzer.entity.ResultCode;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //TODO something
        return new Result("encode all right", ResultCode.OK);
    }
}
