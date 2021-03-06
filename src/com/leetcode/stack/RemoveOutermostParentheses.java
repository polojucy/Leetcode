package com.leetcode.stack;

import java.util.Stack;

/**
 * Created by perl on 2019/7/12.
 *
 * 1021. Remove Outermost Parentheses
 *
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 *
 * Example 1:
 *
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 *
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 *
 * Example 2:
 *
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:

 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 *
 * Example 3:
 *
 * Input: "()()"
 * Output: ""
 * Explanation:
 *
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 * Note:
 * 1、S.length <= 10000
 * 2、S[i] is "(" or ")"
 * 3、S is a valid parentheses string
 */
public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String S) {
        if (S.isEmpty()) {
            return "";
        }
        final Character LEFT_PARENTHESES = '(';
        final Character RIGHT_PARENTHESES = ')';
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for (int i = 0;i < S.length();i++) {
            Character current = S.charAt(i);

            if (current.equals(LEFT_PARENTHESES)) {
                stack.push(current);
            }
            if (current.equals(RIGHT_PARENTHESES)) {
                stack.pop();
            }

            tmp.append(current);

            if (stack.isEmpty()) {
                tmp.deleteCharAt(0);
                tmp.deleteCharAt(tmp.length()-1);
                sb.append(tmp);
                tmp.delete(0,tmp.length());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(RemoveOutermostParentheses.removeOuterParentheses("(()())(())"));
        System.out.println(RemoveOutermostParentheses.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(RemoveOutermostParentheses.removeOuterParentheses("()()"));
    }
}