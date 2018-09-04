package Amazon20180831;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord_819 {
    //Approach #1: Counting [Accepted]
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word : banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();

                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }

                word = new StringBuilder();

            }
        }

        return ans;
    }
    //Time Complexity: O(P + B)O(P+B), where PP is the size of paragraph and BB is the size of banned.
    //Space Complexity: O(P + B)O(P+B), to store the count and the banned set.
}
