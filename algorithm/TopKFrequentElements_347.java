package HighFrequence.Summary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
            System.out.println("frequency: "+  frequency);
            System.out.println("  bucket[frequency]: "+  bucket[frequency]);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                System.out.println("bucket[pos]: "+bucket[pos]);
                res.addAll(bucket[pos]);
            }
        }
        return res.subList(0, k);
    }


    @Test
    public void test(){
        int[] nums = {1,1,1,2,2,2,3,3,3,4,4,5}; int k =2;
        topKFrequent(nums,k);
    }
}
