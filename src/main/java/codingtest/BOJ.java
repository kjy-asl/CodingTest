package codingtest;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ {

    static int[][] map;
    static boolean[][] visited;
    static int[] answer;
    static ArrayList<Integer> arr = new ArrayList<>();
    private void solution(int i, int j){
        visited[i][j] = true;
        if ( j - 1 >= 0 && map[i][j-1] == 1 && !visited[i][j-1] ) {  // search left
            solution(i,j-1);
        }
        if ( j + 1 < map.length && map[i][j+1] == 1 && !visited[i][j+1] ) { // search right
            solution(i,j+1);
        }
        if ( i + 1 < map.length && map[i+1][j] == 1 && !visited[i+1][j] ) { // search down
            solution(i+1,j);
        }
        if ( i - 1 >= 0 && map[i-1][j] == 1 && !visited[i-1][j] ) { // search up
            solution(i-1,j);
        }
    }

    public static void main(String[] args){
        BOJ T = new BOJ();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        answer = new int[N];

        for ( int i = 0 ; i < N ; i++ ) {
            int M = sc.nextInt();
            int L = sc.nextInt();
            int K = sc.nextInt();
            int count = 0;

            map = new int[L][M];
            for ( int j = 0 ; j < K ; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[b][a] = 1;
            }
            visited = new boolean[L][M];

            for ( int k = 0 ; k < L ; k++ ) {
                for ( int l = 0 ; l < M ; l++) {
                    if ( map[k][l] == 1 && !visited[k][l]) {
                        T.solution(k,l);
                        count++;
                    }
                }
            }
            answer[i] = count;
        }
        for ( int ans : answer ) {
            System.out.println(ans);
        }
    }
}
