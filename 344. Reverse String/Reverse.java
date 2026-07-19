class Solution {
    public void reverseString(char[] s) {        
        
        int n = s.length;

        for (int i=0; i<n/2; i++){
        int front = i;
        int back = n - 1 - i;
        char frontChar = s[front];
        char backChar = s[back];      

        s[front] = backChar;
        s[back] = frontChar;
        }
    }
}