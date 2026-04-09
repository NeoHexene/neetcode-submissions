class Solution {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private TrieNode buildTrie (String words[]) {
        
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        return root;
    }

    public List<String> findWords(char[][] grid, String[] words) {
        TrieNode root = buildTrie(words);

        List<String> res = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0 ; j < grid[i].length; j++) {
                dfs(i, j, grid, root, res);
            }
        }


        return res;
    }

    private void dfs(int row, int col, char[][] grid, TrieNode curr, List<String> res) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) {
            return;
        }

        char c = grid[row][col];

        if (c == '#' || curr.children[c - 'a'] == null) {
            return;
        }

        TrieNode next = curr.children[c - 'a'];
        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }

        grid[row][col] = '#';

        dfs(row + 1, col, grid, next, res);
        dfs(row - 1, col, grid, next, res);
        dfs(row, col + 1, grid, next, res);
        dfs(row, col - 1, grid, next, res);

        grid[row][col] = c;
    }

}
