package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/*
 *  Argots, silly secret languages
 *  See https://en.wikipedia.org/wiki/Argot
 *
 *  See:
 *  - UseCharacter
 *  - UseString
 * -  UseStringBuilder
 */
public class Ex2Argots {

    public static void main(String[] args) {
        new Ex2Argots().program();
    }

    void program() {
        out.println(toRobber("Jag talar rövarspråket")
                .equals("JoJagog totalolaror rorövovarorsospoproråkoketot"));

        out.println(toRobber("I speak robber language")
                .equals("I sospopeakok rorobobboberor lolanongoguagoge"));

        out.println(toPigLatin("My name is Eric")
                .equals("yMay amenay isway Ericway"));

    }

    // ---------- Methods --------------------

    private String toRobber(String text) {
        String[] consonante = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","z"};
        String[] splitText = text.split("");
        String robberized = "";
        for (int i = 0; i < text.length(); i++) {
            for (String cons : consonante) {
                if (splitText[i].toLowerCase().equals(cons)) {
                    robberized += splitText[i]+"o";
                }
            }
            robberized += splitText[i];
        }
        return robberized;
    }

    private String toPigLatin(String text) {
        String[] splitText = text.split(" ");
        List<String> vowels = new ArrayList<>(Arrays.asList("a","o","u","e","i","y","å","ä","ö"));
        String pigLatin = "";
        for (int i = 0; i < splitText.length; i++) {
            String temp = "w";
            int count = 0;
            while (count < splitText[i].length() &&
                    !vowels.contains(splitText[i].substring(count,count+1).toLowerCase())) {
                count++;
                temp = splitText[i].substring(0,count);
            }
            pigLatin += splitText[i].substring(count,splitText[i].length()) + temp + "ay" + " ";
        }
        return pigLatin.substring(0,pigLatin.length()-1);       // Returns the string, except the last character: " "
    }






}
