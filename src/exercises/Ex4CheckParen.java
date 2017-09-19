package exercises;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *
 *  Use a stack to check parentheses, balanced and nesting
 *  The parentheses are: (), [] and {}
 *
 *  See:
 *  - UseAStack
 *
 */
public class Ex4CheckParen {


    public static void main(String[] args) {
        new Ex4CheckParen().program();
    }

    void program() {
        // All should be true
        out.println(checkParentheses("()"));
        out.println(checkParentheses("(()())"));
        out.println(!checkParentheses("(()))")); // Unbalanced
        out.println(!checkParentheses("((())")); // Unbalanced

        out.println(checkParentheses("({})"));
        out.println(!checkParentheses("({)}"));  // Bad nesting
        out.println(checkParentheses("({} [()] ({}))"));
        out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting
    }

    // Can handle {}, () and []
    boolean checkParentheses(String expr) {
        expr = expr.trim();
        Stack<Character> grabb = new Stack();
        grabb.push(' ');
        for (char ch : expr.toCharArray()) {
            if(isClosed(ch)) {
                if (matching(ch) != grabb.peek()) {
                    return false;
                } else {
                    grabb.pop();
                }
            } else if (isOpen(ch)) {
                grabb.push(ch);
            }

        }
        grabb.pop();
        return grabb.isEmpty();
    }

    private boolean isOpen(char ch) {
        return "({[".indexOf(ch) > -1;
    }

    private boolean isClosed(char ch) {
        return ")]}".indexOf(ch) > -1;
    }

    // This is interesting because have to return, but what if no match?!?
    char matching(char ch) {
        //char c =  must initialize but to what?!
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                // return c;
                throw new IllegalArgumentException("No match found");
        }
    }
}
