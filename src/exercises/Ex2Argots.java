package exercises;

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
        /*out.println(toRobber("Jag talar rövarspråket")
                .equals("JoJagog totalolaror rorövovarorsospoproråkoketot"));

        out.println(toRobber("I speak robber language")
                .equals("I sospopeakok rorobobboberor lolanongoguagoge"));

        out.println(toPigLatin("My name is Eric")
                .equals("yMay amenay isway Ericway"));
                */
    }

    // ---------- Methods --------------------

    private String toRobber(String text) {
        String[] consonante = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","z"};
        String robberized = "";
        for (int i = 0; i < text.length(); i++) {
            for (String cons : consonante) {
                
            }
        }
        return robberized;
    }






}
