package dev.asmussen;

public class Translator {

    public static String toText(String bits) {

        String translated = "";
        char nextChar;

        for(int i = 0; i <= bits.length()-8; i += 8) {

            nextChar = (char) Integer.parseInt(bits.substring(i, i+8), 2);
            translated += nextChar;
        }

        return translated;

    }

    public static String toBinary(String text) {

        String translated = "";

        char[] messChar = text.toCharArray();

        for(int i = 0; i < messChar.length; i++) {
            
            translated += Integer.toBinaryString(messChar[i]) + " ";
        }

        return translated;
    }
}
