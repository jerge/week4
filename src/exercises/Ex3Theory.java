package exercises;

/*
 *  For each of the section below. Uncomment and explain
 *
 */
import static java.lang.System.*;

public class Ex3Theory {

    public static void main(String[] args) {
        new Ex3Theory().program();
    }

    void program() {
        // 1. Uncomment section below and you will get compile errors. Why?

        int i = 1;
        char ch = '1';
        double d = 1.0;
        /*
        i = d; //i is a int and d is a double. They're not compatible
        i = ch;
        ch = i; //ch is a char while i is a int. Not compatible
        ch = d; //ch is a char while d is a double. Not compatible
        d = i;
        d = ch;

        i = (int) d;
        (double) i = d; //Man får inte casta till vänster om tilldelningen
        */
        // 2. -------------------------------------------

        // Uncomment and run. Which value is correct for the volume of a sphere?

        // Vol 4 is wrong because it divides by pi, because of the parenthesis
        // Vol 2 & 3 are wrong because it divides two integers and expects a double, which it won't get
        // Vol 1 is correct

        int r = 10;
        double pi = 3.141;
        double vol1 = 4 * pi / 3 * r * r * r;
        double vol2 = pi * r * r * r * (4 / 3);
        double vol3 = 4 / 3 * pi * r * r * r;
        double vol4 = 4 / (3 * pi) * r * r * r;

        out.println(vol1);
        out.println(vol2);
        out.println(vol3);
        out.println(vol4);




        // 3. ---------------------------------------------------

        // Uncomment section below and you will get compile errors. Why?
        {
            int x = 0;
            {
                // int x = 0;       // x is already defined in this scope
                int y = 0;
                out.println(x);
                out.println(y);
            }
            // int x = 0;       // x is already defined in this scope
            int y = 0;          // Works because the y variable defined earlier is forgotten between scopes
            out.println(x);
            out.println(y);
        }
        // out.println(x);      // x is not defined in this scope any longer
        // out.println(y);      // y is not defined in this scope any longer


        // 4. ----------------------------------------------------------

        // Uncomment and run. Explain result!
        double d1 = 1.0;
        double d2 = 1.0;
        d1 = d1 - 0.7 - 0.3;        // doubles does not have to be exact, due to the bit representation
        d2 = d2 - 0.6 - 0.4;
        out.println(d1 == 0);
        out.println(d2 == 0);
        out.println(d1 == d2);


        // 5. -----------------------------------------------------

        // Uncomment and run. Explain output!

        out.println(1 + 2);             // Outputs the integers added
        out.println("2 + 1");           // Outputs the string
        out.println(1 + 2.0 + "a");     // Outputs the double 1+2.0 and then adds the string "a"
        out.println("a" + 1 + 2);       // Outputs the string followed by the integer 1 and 2
        out.println('a' + 1 + 2);       // The numeral representation for the char 'a' is 97
        out.println("a" + 'a');         // Here it doesn't add 'a' since we have already defined that we want a string


    }
}