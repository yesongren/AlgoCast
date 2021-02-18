package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2021/2/18
 * 146. LRU Cache
 */
public class P024_LRUCache {
}

class LinkNode {
    int key;
    int val;
    LinkNode front;
    LinkNode next;

    LinkNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int capacity;
    private Map<Integer, LinkNode> map = new HashMap<>();
    private LinkNode head = new LinkNode(0, 0);
    private LinkNode tail = new LinkNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            detachAndMoveToTop(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) deleteLastNode();
            LinkNode newNode = new LinkNode(key, value);
            LinkNode temp = head.next;
            head.next = newNode;
            newNode.front = head;
            newNode.next = temp;
            temp.front = newNode;
            map.put(key, newNode);
        } else {
            LinkNode node = map.get(key);
            node.val = value;
            detachAndMoveToTop(node);
        }
    }

    private void deleteLastNode() {
        LinkNode lastNode = tail.front;
        lastNode.front.next = tail;
        lastNode.next.front = lastNode.front;
        map.remove(lastNode.key);
    }

    private void detachAndMoveToTop(LinkNode node) {
        // detach
        node.front.next = node.next;
        node.next.front = node.front;
        // attach
        LinkNode temp = head.next;
        head.next = node;
        node.front = head;
        node.next = temp;
        temp.front = node;
    }
}
