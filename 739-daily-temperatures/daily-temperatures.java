class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int n = temperatures.length;
        int[] result = new int[n];

        for(int id = n-1; id>=0; id--){
            while(!stack.isEmpty() && temperatures[id] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[id] = stack.peek() - id;
            }
            stack.push(id);
        }
        return result;
    }
}