class Solution{
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] counts = new int[26];
        // Count frequencies
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        // Subtract based on ransomNote requirements
        for (char c : ransomNote.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false; // Not enough characters
            }
            counts[c - 'a']--;
        }

        return true;
    }
}