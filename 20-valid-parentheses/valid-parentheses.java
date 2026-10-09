import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            // Opening bracket → PUSH
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            }
            // Closing bracket
            else {
                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                // Check whether brackets match
                if (current == ')' && top == '(' ||
                    current == '}' && top == '{' ||
                    current == ']' && top == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // Valid only if no opening brackets are left
        return stack.isEmpty();
    }
}