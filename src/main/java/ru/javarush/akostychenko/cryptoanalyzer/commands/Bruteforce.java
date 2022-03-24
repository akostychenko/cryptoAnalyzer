package ru.javarush.akostychenko.cryptoanalyzer.commands;


import ru.javarush.akostychenko.cryptoanalyzer.constants.Constants;
import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;
import ru.javarush.akostychenko.cryptoanalyzer.entity.ResultCode;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;

public class Bruteforce implements Action {
    @Override
    public Result execute(String[] parameters) {
        String inputFile = parameters[0];
        String outputFile = parameters[1];
        toBruteforce(inputFile, outputFile);
        return new Result("Файл раскодирован методом перебора", ResultCode.OK);
    }

    private void toBruteforce(String inputFile, String outputFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.TXT_FOLDER + inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constants.TXT_FOLDER + outputFile))) {
            ArrayList<String> inputData = new ArrayList<>();
            ArrayList<String> outputData = new ArrayList<>();

            while (bufferedReader.ready()) {
                inputData.add(bufferedReader.readLine());
            }
            Instant timer = Instant.now();
            long startT = timer.toEpochMilli();
            for (int key = 1; key < Constants.ALPHABET.size(); key++) {
                for (String string : inputData) {
                    char[] chars = string.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        int index = Constants.ALPHABET.indexOf(Character.toLowerCase(chars[i]));
                        if (index == -1) {
                            continue;
                        }

                        int shift = (index - key) % Constants.ALPHABET.size();
                        if (shift < 0) shift = shift + Constants.ALPHABET.size();
                        chars[i] = Constants.ALPHABET.get(shift);
                    }
                    outputData.add(new String(chars));
                }

                boolean isCorrectLength = true;
                boolean isCorrectWord;
                int notCorrectWord = 0;
                int countWords = 0;

                for (String string : outputData) {
                    if (string.matches("(.*)[a-zA-Z](.*)")) {
                        continue;
                    }
                    String[] stringsLength = string.split(" ");
                    for (String s : stringsLength) {
                        if (s.length() > 25) {
                            isCorrectLength = false;
                            break;
                        }
                    }

                    String[] stringsWord = string.split("[?!.]");
                    for (String s : stringsWord) {
                        if (stringsWord.length == 1 | s.length() == 1 | s.isEmpty()) {
                            break;
                        }
                        if (!s.startsWith(" ")) {
                            notCorrectWord++;
                        }
                    }
                }

                for (String string : outputData) {
                    String[] words = string.split(" ");
                    countWords += words.length;
                }

                isCorrectWord = notCorrectWord <= countWords / 10;

                if (isCorrectLength & isCorrectWord) {
                    timer = Instant.now();
                    long stopT = timer.toEpochMilli();
                    System.out.println("Значение подобранного ключа - " + key);
                    System.out.printf("Затрачено: %.2f сек.\n", (stopT - startT) / 1000.0F);
                    break;
                }
                outputData.clear();
            }

            for (String string : outputData) {
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}