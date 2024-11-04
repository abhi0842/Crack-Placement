package Trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root;
    public ImplementTriePrefixTree() {
        root = new TrieNode();

    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }
    private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }
}
