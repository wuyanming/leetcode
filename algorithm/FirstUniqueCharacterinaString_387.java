package HighFrequence.Summary;

public class FirstUniqueCharacterinaString_387 {
    //Nice Solution, one thing need to notice that if the string contains any characters which are represented by ASCII,
    //we'd better use int[256].

    public int firstUniqChar(String s) {
        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}
