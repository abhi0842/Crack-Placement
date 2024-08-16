package Stack;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final Node head=new Node();
    final Node tail=new Node();
    Map<Integer,Node> cache;
    int n;
    public LRUCache(int capacity) {
        cache=new HashMap(capacity);
        this.n=capacity;
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        int result=-1;
        Node node=cache.get(key);
        if(node!=null){
            result=node.val;
            remove(node);
            add(node);
        }
        return result;

    }

    public void put(int key, int value) {
        Node node =cache.get(key);
        if(node!=null){

            remove(node);
            node.val=value;
            add(node);
        }
        else{
            if(cache.size()==n){
                cache.remove(tail.pre.key);
                remove(tail.pre);
            }
            Node newnode=new Node();
            newnode.key=key;
            newnode.val=value;
            cache.put(key,newnode);
            add(newnode);
        }
    }
    public void add(Node node){
        Node next_node=head.next;
        head.next=node;
        node.pre=head;
        node.next=next_node;
        next_node.pre=node;
    }
    public void remove(Node node){
        Node next_node=node.next;
        Node pre_node =node.pre;
        next_node.pre=pre_node;
        pre_node.next=next_node;
    }
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
    }

    public static void main(String[] args) {
        int capacity=3;
        int key=2;
        int value=4;
        LRUCache obj = new LRUCache(capacity);
         int param_1 = obj.get(key);
          obj.put(key,value);
    }
}
