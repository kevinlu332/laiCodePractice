import java.util.*;

public class aliendict {
    public String alienOrder(String[] words) {
        // Write your solution here
        //from left to right(shorter end of two string) of two string, the first diff means order'
        //case: different
        //first diff: str2.[letter -'a'] +=1
        //[26] with 0 for in-degrees
        int[] indegrees = new int[26];
        Map<Character, Set<Character>> map = new HashMap<>();
        for(int i = 0; i<words.length-1; i++){
            handleDiffLetters(words[i], words[i+1], map, indegrees);
        }
        StringBuilder sb = new StringBuilder();
        return topo(map, indegrees, sb);
    }
    private String topo(Map<Character, Set<Character>> map, int[] indegrees, StringBuilder sb){
        List<Character> queue = new ArrayList<>();
        for(int x = 0; x<indegrees.length; x++){
            if(indegrees[x]==0){
                if(map.containsKey((char)('a'+ x))){
                    queue.add((char)('a'+ x));
                }
            }
        }
        while(!queue.isEmpty()){
            char cur = queue.remove(0);
            sb.append(cur);
            if(map.containsKey(cur)){
                Set<Character> set = map.get(cur);
                for(char c : set){
                    indegrees[c-'a']--;
                    if  (indegrees[c-'a']==0)queue.add(c);
                }
            }
        }
        return sb.toString();
    }
    private void handleDiffLetters(String s1, String s2, Map<Character, Set<Character>> map, int[] indegrees){
        int i ;
        for(i = 0; i<Math.min(s1.length(), s2.length()); i++){
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(c1!=c2) {
                Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                if(!set.contains(c2)){
                    set.add(c2);
                    map.put(c1, set);
                    indegrees[c2-'a']++;
                }
                break;
            }
        }
        return;
    }
//    public static void main(String[] args){
//        aliendict s = new aliendict();
//        String[] words = new String[]{"bpdpwwzw","zppp","pb","pzddz","pp","dbw","dwb","z"};
//        String ans =s.alienOrder(words);
//        System.out.println(ans);
//    }
}
