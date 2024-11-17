class Solution {
    static boolean[] visited; 
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int result = 0;
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                // visited[i] = true;
                dfs(i, computers);
                result+=1;
            }
        }
        
        return result;
    }
    
    public static void dfs(int n, int[][] computers) {
        visited[n] = true;
        for(int i=0; i<computers[n].length; i++) {
            if(!visited[i] && computers[n][i]==1) {
                dfs(i,computers);
            }
        }
    }
}