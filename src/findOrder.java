import java.util.*;

public class findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your solution here
        Map<Integer, Set<Integer>> graph = getGraph(prerequisites);
        int[] indegrees = new int[numCourses];
        for(Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()){
            for(int x: entry.getValue()){
                indegrees[x]++;
            }
        }
        return topo(graph, indegrees, numCourses);
    }
    private int[] topo(Map<Integer, Set<Integer>> graph, int[] indegrees, int numCourses){
        List<Integer> queue = new ArrayList<>();
        for(int i = 0; i<indegrees.length; i++){
            if(indegrees[i]==0) queue.add(i);
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int cur = queue.remove(0);
            ans[index++] = cur;
            if(graph.containsKey(cur)){
                Set<Integer> to_set = graph.get(cur);
                for(Integer x : to_set){
                    if(x!=null) {
                        indegrees[x]--;
                        if(indegrees[x]==0) queue.add(x);
                    }
                }
            }
        }
        if(index==numCourses) return ans;
        else return new int[0];
    }
    private Map<Integer,Set<Integer>> getGraph(int[][] pres){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edges: pres){
            int to = edges[0], from  = edges[1];
            if(graph.containsKey(from)){
                graph.get(to).add(from);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(to);
                graph.put(from, set);
            }
        }
        return graph;
    }

//    public static void main(String[] args){
//        findOrder s = new findOrder();
//
//        int[] ans =s.findOrder(4, new int[][]{{3,1},{2,0},{1,2},{0,3}});
//        for(int x: ans) System.out.println(x);
//    }

}
