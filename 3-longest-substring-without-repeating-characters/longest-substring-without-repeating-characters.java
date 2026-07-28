class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> Index= new HashMap<>();
        int maxLength = 0;
        int left= 0;

        for (int right= 0; right< s.length(); right++) {
            char currentChar = s.charAt(right);
            if (Index.containsKey(currentChar)) {
                left = Math.max(Index.get(currentChar) +1, left);
            }
            Index.put(currentChar, right);
            maxLength = Math.max(maxLength, right-left +1);
        }
        return maxLength;      
    }
}