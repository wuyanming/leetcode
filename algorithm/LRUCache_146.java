package Amazon20180831;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/description/
public class LRUCache_146 {
    public class LRUCache {
        private Map<Integer, DLinkNode> cache;
        DLinkNode tail = null;
        DLinkNode head = null;
        int capacity;

        public LRUCache(int capacity) {
            cache = new HashMap<Integer, DLinkNode>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                DLinkNode target = cache.get(key);
                int value = target.value;
                target.update();
                return value;
            } else return -1;
        }

        public void set(int key, int value) {
            if (cache.containsKey(key)) {
                DLinkNode target = cache.get(key);
                target.value = value;
                target.update();
            } else {
                if (capacity == 0) return;
                if (cache.size() == capacity) {
                    cache.remove(head.key);
                    head.removeFromHead();
                }
                DLinkNode newNode = new DLinkNode(key, value);
                newNode.append();
                cache.put(key, newNode);
            }
        }

        class DLinkNode {
            int key;
            int value;
            DLinkNode left = null;
            DLinkNode right = null;

            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            // remove head from list and update head reference.
            private void removeFromHead() {
                // if 'this' is the only node, set both head and tail to null.
                if (tail == this) {
                    head = null;
                    tail = null;
                } else {
                    head = this.right;
                    head.left = null;
                }
            }

            private void update() {
                // no need to update if accessing the most revently used value.
                if (tail == this) return;
                else {
                    // remove from current postion and update nodes (if any) on both sides.
                    if (this != head) {
                        this.left.right = this.right;
                    } else {
                        head = this.right;
                    }
                    this.right.left = this.left;
                    // append to tail.
                    this.append();
                }
            }

            private void append() {
                // inserting the first node.
                if (tail == null) {
                    head = this;
                    tail = this;
                    // appned as tail and update tail reference.
                } else {
                    this.right = null;
                    this.left = tail;
                    tail.right = this;
                    tail = this;
                }
            }
        }
    }

}
