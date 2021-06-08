class Solution {
    //深度优先
    List<List<Integer>> edges ;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges= new ArrayList<List<Integer>>();
        for(int i = 0 ; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());

        }

        visited = new int[numCourses];
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }
    public void dfs(int i){
        visited[i] = 1;
        for(int v : edges.get(i)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            }else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}