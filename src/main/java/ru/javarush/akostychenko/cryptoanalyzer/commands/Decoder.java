package ru.javarush.akostychenko.cryptoanalyzer.commands;
import ru.javarush.akostychenko.cryptoanalyzer.constants.Constants;
import ru.javarush.akostychenko.cryptoanalyzer.entity.Result;
import ru.javarush.akostychenko.cryptoanalyzer.entity.ResultCode;

import java.io.*;
import java.util.ArrayList;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        String inputFile = parameters[0];
        String outputFile = parameters[1];
        String encryptionKeyString = parameters[2];
        toDecode(inputFile, outputFile, encryptionKeyString);
        return  new Result("Файл раскодирован", ResultCode.OK);
    }

    private void toDecode(String inputFile, String outputFile, String encryptionKeyString) {
        int encryptionKeyValue;
        encryptionKeyValue = Integer.parseInt(encryptionKeyString);
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(Constants.TXT_FOLDER + inputFile) );
             BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(Constants.TXT_FOLDER + outputFile))) {
            ArrayList<String> data = new ArrayList<>();
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                char[] chars = string.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    int index = Constants.ALPHABET.indexOf(Character.toLowerCase( chars[i]));
                    if (index == -1) {
                        continue;
                    }

                    int shift;
                    if (encryptionKeyValue > 0) {
                        shift = (index - encryptionKeyValue) % Constants.ALPHABET.size();
                    } else shift = (index + encryptionKeyValue) % Constants.ALPHABET.size();
                    if (shift < 0) shift = shift + Constants.ALPHABET.size();
                    chars[i] = Constants.ALPHABET.get(shift);
                }
                data.add(new String(chars));
            }

            for (String string : data) {
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
