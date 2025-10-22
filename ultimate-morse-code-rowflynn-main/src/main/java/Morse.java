import java.util.*;

public class Morse {

    private static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0" };

    private static String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----" };

    public static ArrayList<String> decodeMorse(String encMessage) {
        /**
         * HINT: use your own methods to execute your recursion
         * (feel free to add as many methods as you need),
         * you CANNOT change the number of arguments in
         * this `decodeMorse` method
         */
        ArrayList<String> result = new ArrayList<>();
        decode(encMessage, "", 0, result);
        return result;
    }

    public static void decode(String encMessage, String curr, int index, ArrayList<String> result) {
       
            if (index == encMessage.length()) {
                result.add(curr);
                return;
            }
            
            // Chat GPT used to help construct for loop and recursive call
            for (int i = index+1; i <= encMessage.length(); i++) {
                if (isMorse(encMessage.substring(index, i))) {
                    String morse = (getMorse(encMessage.substring(index, i)));
                    decode(encMessage, curr + morse, i, result);
                }
            
        }
        

    }

    public static Boolean isMorse(String letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (letter.equals(morseCodes[i])) {
                return true;
            }
        }
        return false;
    }
    public static String getMorse(String letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (letter.equals(morseCodes[i])) {
                return alphabet[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        /**
         * The `decoded` array list should contain
         * ["tet", "ta", "nt", "k"] in any order
         * if you pass "-.-" as an argument
         */
        ArrayList<String> decoded = decodeMorse("-.-.-");
        System.out.println(decoded);
    }
}