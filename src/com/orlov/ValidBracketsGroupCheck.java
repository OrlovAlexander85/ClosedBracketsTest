package com.orlov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidBracketsGroupCheck {

    public boolean isValid(String s) {
        HashMap<Character, Character> closeBracketMap = new HashMap<Character, Character>();
        closeBracketMap.put(')', '(');
        closeBracketMap.put(']', '[');
        closeBracketMap.put('}', '{');
        closeBracketMap.put('>', '<');
        HashSet<Character> openBracketSet = new HashSet<Character>(
                closeBracketMap.values());
        Stack<Character> stack = new Stack<Character>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (openBracketSet.contains(currentChar)) {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (closeBracketMap.get(currentChar) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
