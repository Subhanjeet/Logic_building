class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<int[]> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{ch, 1});
            }
        }

        StringBuilder result = new StringBuilder();

        for (int[] pair : stack) {
            char ch = (char) pair[0];
            int count = pair[1];
            while (count-- > 0) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}