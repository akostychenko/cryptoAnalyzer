package ru.javarush.akostychenko.cryptoanalyzer.constants;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Constants {
    public static List<Character> ALPHABET = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '«', '»', ':', '!', '?', ' ', '"', '-', '=', '+', '_', ')', '(', '*');
    public static final String TXT_FOLDER = System.getProperty("user.dir")+ File.separator+"text"+File.separator;
}