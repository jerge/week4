package samples;

import static java.lang.System.out;

/*
 *  Enum (enumeration) is a type for some small set of values.
 *  All values that belong to type is explicitly written out when enum created
 *  (so must be small set)
 *
 *  All Enum's are reference types, values accessed through reference.
 *  Equality is by reference (==) because each value is one unique object.
 *
 *  Enums are used because they are type safe (using String or int for days
 *  is not safe, i.e. compiler can't catch misspellings or invalid numbers)
 */

public class UseEnum {

    public static void main(String[] args) {
        new UseEnum().program();
    }

    // Declare the enum type
    enum WeekDay {
        MON, TUE, WED, THU, FRI, SAT, SUN  // List all values that belong to type
    }

    void program() {
        WeekDay d1 = WeekDay.FRI;   // Declare variable of enum type and assign value
        WeekDay d2 = WeekDay.THU;

        //WeekDay d3 = "SUN";    // No SUN is a string, wrong type
        WeekDay d4 = WeekDay.FRI;

        out.println(d1 != d2);  // Not equal (by reference)
        out.println(d1 == d4);  // References same object (FRI).

        out.println( d1.ordinal() );  // Values are numbered, starting at 0
        out.println( d2.ordinal() );

        WeekDay[] days = WeekDay.values();  // Possible to loop through all
        for (int i = 0; i < days.length; i++) {
            out.println(days[i]);  // Will automatically convert to String
        }

        // Conversion from String
        WeekDay d5 = WeekDay.valueOf("SUN");  // String must be exactly as enum  "SUN" <-> SUN
        out.println( d5 );
    }
}



