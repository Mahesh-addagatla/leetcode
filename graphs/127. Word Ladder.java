class Pair{
        String word;
        int consec;
        Pair(String word,int consec){
            this.word = word;
            this.consec = consec;
        }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.word;
            int con = p.consec;
            if(word.equals(endWord))return con;
            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char[] replaceWord = word.toCharArray();
                    replaceWord[i] = c;
                    String newWord = new String(replaceWord);
                    if(hs.contains(newWord)){
                        hs.remove(newWord);
                        q.add(new Pair(newWord,con+1));
                    }
                }
            }
        }
        return 0;
    }
}
