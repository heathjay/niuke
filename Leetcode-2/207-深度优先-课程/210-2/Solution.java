class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited ;
    int[] result;
    boolean valid = true;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses-1;
        for(int i = 0 ; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }

        for(int[] p : prerequisites){
            edges.get(p[1]).add(p[0]);
        }

      
        for(int i = 0; i< numCourses; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }

        if(!valid){
            return new int[0];
        }

        return result;
    }
    public void dfs(int i){
       
        visited[i] = 1;
        for(int v : edges.get(i)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            }
            else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        result[index --] = i;

    }
}