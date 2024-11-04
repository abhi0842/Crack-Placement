package Trie;

public class DesignAddandSearchWordsDataStructure {
    private TrieNode root;
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // 26 lowercase English letters
            isEndOfWord = false;
        }
    }
    public DesignAddandSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // If the character is '.', check all possible nodes at this level
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                // If the character is a letter, proceed normally
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false; // No such path in the Trie
                }
                node = node.children[index];
            }
        }
        return node.isEndOfWord;
    }
}
