class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == currentChar) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(currentChar);
            }
        }
        return stack.toString();
    }
}

//create stack
//loop through every char
//get current char
//check whether if, stack is not empty and get the top char and compare it with current char
//if satisfy than, remove the top char
//otherwise add the char
//return final result