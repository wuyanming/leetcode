package Amazon20180831;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146_2 {
    //Similar solution without using removeEldestEntry
    public class LRUCache {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        int cap = 0;

        public LRUCache(int capacity) {
            cap = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                int value = cache.get(key);
                cache.remove(key);
                cache.put(key, value);
                return value;
            }
            return -1;
        }

        public void set(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                cache.put(key, value);
            } else if (cache.size() == cap) cache.remove(cache.entrySet().iterator().next().getKey());
            cache.put(key, value);
        }
    }


    //This is the laziest implementation using Java's LinkedHashMap. In the real interview, however, it is definitely not what interviewer expected.
    public class LRUCache_Second {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;

        public LRUCache_Second(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void set(int key, int value) {
            map.put(key, value);
        }
    }
}
