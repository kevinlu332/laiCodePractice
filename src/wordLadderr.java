import java.util.*;

public class wordLadderr {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    /*
    bfs
    steps
    Set visited : record the visited words in wordList
    if get out of loop, return 0;
    queue <char[]>
    hit  -> if(==endword) return ans;
                    -> 25*3 ->
                    if(exist in wordList &&!visited):                      add to queue, visited

    */
        Set<String> wordSet = new HashSet<>(wordList);
        List<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        wordSet.add(beginWord);
        visited.add(beginWord);
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int i = 0; i<size; i++){
                String cur = q.remove(0);
                if(cur.equals(endWord)) return step;
                char[] curCharArr = cur.toCharArray();
                for(int j = 0; j<curCharArr.length; j++){
                    for(int k =0; k<26; k++){
                        if((char)('a'+k)==curCharArr[j]) continue;
                        curCharArr[j] = (char)(k+'a');
                        String next = new String(curCharArr);
                        if(wordSet.contains(next) && !visited.contains(next)){
                            q.add(next);
                            visited.add(next);
                        }

                    }
                }
            }

        }
        return 0;
    }
    public static void main(String[] args){
        List<String> list = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        ladderLength("hit", "cog", list);
    }

}
