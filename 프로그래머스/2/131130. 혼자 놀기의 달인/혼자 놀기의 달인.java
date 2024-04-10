class Solution {
    static boolean[] visited;
    
    public int solution(int[] cards) {
        visited = new boolean[cards.length+1];
        int maxNum = 0;
        int maxSecondNum = 0;
        for (int i  = 1 ; i <= cards.length ; i++) {
            if (visited[i] == false) {
                int len = dfs(cards, i);
                if (len > maxNum) {
                    if (maxNum == 0) {
                        maxNum = len;
                    }else{
                        maxSecondNum = maxNum;
                        maxNum = len;
                    }
                }
                else if (len > maxSecondNum) maxSecondNum = len;
            }
        }
        
        return maxNum * maxSecondNum;
    }
    
    private static int dfs(int[] cards, int idx) {
        visited[idx] = true;
        if (visited[cards[idx-1]] == false) {
            return dfs(cards, cards[idx-1])+1;
        }
        return 1;
    }
}