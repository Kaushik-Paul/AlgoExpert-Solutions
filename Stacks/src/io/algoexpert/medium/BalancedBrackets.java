package io.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean checkBalancedBrackets2(String string) {
        char[] openingBracket = new char[]{'(', '[', '{'};
        char[] closingBracket = new char[]{')', ']', '}'};
        Map<Character, Character> matchingBrackets = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        boolean status = false;
        for (char ch : string.toCharArray()) {
            status = false;
            for (char check : openingBracket) {
                if (ch == check) {
                    stack.push(ch);
                    status = true;
                    break;

                }
            }
            if (status) {
                continue;
            }
            for (char check : closingBracket) {
                if (ch == check) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (matchingBrackets.get(ch) == stack.peek()) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();

    }

    public static boolean checkBalancedBrackets(String string) {
        Map<Character, Character> matchingBrackets = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        Set<Character> openingBracket = Set.of('(', '{', '[');
        Set<Character> closingBracket = Set.of(')', '}', ']');
//        Set<Character> openingBracket = new HashSet<>();
//        Set<Character> closingBracket = new HashSet<>();
//        openingBracket.add('(');
//        openingBracket.add('{');
//        openingBracket.add('[');
//        closingBracket.add(')');
//        closingBracket.add('}');
//        closingBracket.add(']');

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (openingBracket.contains(ch)) {
                stack.push(ch);
            }
            if (closingBracket.contains(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == matchingBrackets.get(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String string = "(([]()()){})";
        if (checkBalancedBrackets(string)) {
            System.out.println("The following string is a matching bracket");
        } else {
            System.out.println("The following string is not a matching bracket");
        }
    }
}
