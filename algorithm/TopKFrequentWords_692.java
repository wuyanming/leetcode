package Amazon20180831;

import java.util.*;

public class TopKFrequentWords_692 {
    //Approach #2: Heap [Accepted]
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2));

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
    //Time Complexity: O(N \log{k})O(Nlogk), where NN is the length of words. We count the frequency of each word in O(N)O(N) time,
    //then we add NN words to the heap, each in O(\log {k})O(logk) time.
    //Finally, we pop from the heap up to kk times. As k \leq Nk≤N, this is O(N \log{k})O(Nlogk) in total.
    //Space Complexity: O(N)O(N), the space used to store our count.


    //Approach #1: Sorting [Accepted]
    public List<String> topKFrequent_Second(String[] words, int k) {
        Map<String, Integer> count = new HashMap();

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> candidates = new ArrayList(count.keySet());

        Collections.sort(candidates, (w1, w2) ->
                count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }
    //Time Complexity: O(N \log{N})O(NlogN), where NN is the length of words.
    //We count the frequency of each word in O(N)O(N) time, then we sort the given words in O(N \log{N})O(NlogN) time.
    //Space Complexity: O(N)O(N), the space used to store our candidates.
}
