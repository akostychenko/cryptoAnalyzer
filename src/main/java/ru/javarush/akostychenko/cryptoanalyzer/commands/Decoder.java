package ru.javarush.akostychenko.cryptoanalyzer.commands;

import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;
import ru.javarush.akostychenko.cryptoanalyzer.entity.ResultCode;

public class Decoder implements Action{

    @Override
    public Result execute(String[] parameters) {
        //TODO something
        return new Result("decode all right", ResultCode.OK);

    }
}
