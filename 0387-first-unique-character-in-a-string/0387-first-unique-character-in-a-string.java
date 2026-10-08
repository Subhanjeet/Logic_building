import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {

        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        // frequency of every character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // first character with frequency 1
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}