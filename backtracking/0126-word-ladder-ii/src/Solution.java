import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 这是 TLE 解
public class Solution {

    private List<List<String>> res = new ArrayList<>();
    private Set<String> used = new HashSet<>();
    private List<String> pre = new LinkedList<>();
    private int maxDepth = 0;

    private List<String> onlyOne(List<String> wordList, String word) {
        List<String> nextWords = new ArrayList<>();
        int len = word.length();
        for (String match : wordList) {
            assert match.length() == len;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (match.charAt(i) != word.charAt(i)) {
                    count++;
                }
            }
            if (count == 1 && !used.contains(match)) {
                nextWords.add(match);
                used.add(match);
            }
        }
        return nextWords;
    }


    private class Pair {
        private String word;
        private Integer step;

        public Pair(String word, Integer step) {
            this.word = word;
            this.step = step;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair curPair = queue.removeFirst();
            String curWord = curPair.word;
            Integer curStep = curPair.step;
            curStep++;
            List<String> nextWords = onlyOne(wordList, curWord);
            for (String nextWord : nextWords) {
                // 【重点2】在这里存储父亲关系
                if (nextWord.equals(endWord)) {
                    maxDepth = curStep;
                    break;
                }
                queue.addLast(new Pair(nextWord, curStep));
                used.add(nextWord);
            }
        }
        // System.out.println("最大深度是 " + maxDepth);
        used = new HashSet<>();
        List<String> pre = new ArrayList<>();
        pre.add(beginWord);
        dfs(beginWord, endWord, wordList, 1, pre);
        return res;
    }


    private void dfs(String beginWord, String endWord, List<String> wordList, int depth, List<String> pre) {
        if (depth == maxDepth && beginWord.equals(endWord)) {
            res.add(new ArrayList<>(pre));
            return;
        }

        List<String> nextWords = onlyOne(wordList, beginWord);

        // System.out.println(nextWords);
        // System.out.println("used 集合 ：" + used);
        for (String nextWord : nextWords) {
            pre.add(nextWord);
            dfs(nextWord, endWord, wordList, depth + 1, pre);
            used.remove(nextWord);
            pre.remove(pre.size() - 1);

        }
    }


    public static void main(String[] args) {
        // write your code here
        // write your code here

//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");
//
//
//        Solution solution = new Solution();
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);


//        String[] words ={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//        List<String> wordList = new ArrayList<>();
//
//        for(String word:words){
//            wordList.add(word);
//        }
//        Solution solution = new Solution();
//        String beginWord = "qa";
//        String endWord = "sq";
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);


        String[] words = {"rex", "ted", "tex", "tad", "tax"};
        List<String> wordList = new ArrayList<>();

        for (String word : words) {
            wordList.add(word);
        }
        Solution solution = new Solution();
        String beginWord = "red";
        String endWord = "tax";
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);

    }
}
