package exercises;

import static java.lang.System.out;

/**
 *  A String problem
 *
 *  See:
 *  - UseString
 */
public class Ex5StringOrdering {

    public static void main(String[] args) {
        new Ex5StringOrdering().program();
    }

    void program() {

        // Yes, "aa bb cc" is ordered like "abc" because all
        // a's are before all b's that are before all c's
        out.println(isOrdered("abc", "aa bb cc"));
        // Yes, all a's before all b's
        out.println(isOrdered("ab", "aa eee bb ddd cc"));
        // Yes, all e's before all c's
        out.println(isOrdered("ec", "aa eee becb c dddc"));

        // Not all c's are before all b's
        out.println(!isOrdered("acb", "aa bb cc"));
        // Not all b's before all c's
        out.println(!isOrdered("abc", "aa bb ccc b"));
        // No!
        out.println(!isOrdered("bac", "aa eee bbb ddd ccc"));

        // Degenerate cases
        out.println(isOrdered("a", "aa bb cc"));
        out.println(isOrdered("", "aa bb cc"));
        out.println(isOrdered("abc", ""));
        out.println(!isOrdered("ax", "aa bb cc"));       // Wrong in assignment, second last statement returns true on the same basis

    }

    private boolean isOrdered(String key, String text) {
        text = text.trim();
        String[] keyArr = key.split("");
        String[] textArr = text.split("");
        for (int j = 0; j < keyArr.length-1; j++) {
            for (int i = 0; i < textArr.length; i++) {
                if (textArr[i].equals(keyArr[j]) && text.substring(0, i).contains(keyArr[j+1])) {
                    return false;
                }
            }
        }
        return true;
    }







}
