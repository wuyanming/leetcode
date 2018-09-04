package Amazon20180831;

import java.util.*;

public class Word_Ladder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        for (int len = 1; !q.isEmpty(); len++) {

            for (int i = q.size(); i > 0; i--) {
                String w = q.poll();
                if (w.equals(endWord)) return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (dict.contains(nb) && vis.add(nb)) q.offer(nb);//// Set容器添加元素时，若此元素已存在，则返回false
                    }

                }

            }

        }
        return 0;
    }
}
