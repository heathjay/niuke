class Solution {
    //假设字符串 
/**
 * 具体做法是，使用哈希表存储字符串 
s
s 的每个下标和从该下标开始的部分可以组成的句子列表，在回溯过程中如果遇到已经访问过的下标，则可以直接从哈希表得到结果，而不需要重复计算。如果到某个下标发现无法匹配，则哈希表中该下标对应的是空列表，因此可以对不能拆分的情况进行剪枝优化。

 */
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();

        List<List<String>> wordBreaks = backtrace(s, new HashSet<String>(wordDict), 0, map);

        List<String> breakList = new LinkedList<String>();

        for(List<String> wordBreak : wordBreaks){
            breakList.add(String.join(" "), wordBreak);
        }
        return breakList;
    }


    public List<List<String>> backtrace(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>> map){
        if(!map.containsKey(index)){
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if(index == length){
                wordBreaks.add(new LinkedList<String>());
            }
            for(int i = index + 1; i <= length; i++){
                String word = s.substring(index, i);
                if(wordSet.contains(word)){
                    List<List<String>> nextWordBreaks = backtrace(s, length,wordSet, i, map);
                    for(List<String> nextWordBreak : nextWordBreaks){
                        LinkedList<String> wordBreak = new LinkedList<>();
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}