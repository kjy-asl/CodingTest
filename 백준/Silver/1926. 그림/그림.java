
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] visited;
    static int N,M,max;

    public static void main(String[] args) {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N][M];
        visited = new int[N][M];
        max = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int numOfPrint = 0;
        for (int i = 0 ; i <N ; i++) {
            for (int j = 0; j < M ; j++) {
                if (visited[i][j] == 0 && arr[i][j] == 1) {
                    visited[i][j]=1;
                    int bfs = m.BFS(i,j);
                    if (max < bfs) max = bfs;
                    numOfPrint++;
                }
            }
        }
        System.out.printf("%d\n%d", numOfPrint, max);
    }

    private int BFS(int i, int j) {
        int answer = 1;
        if (i+1<N && arr[i+1][j] == 1 && visited[i+1][j] == 0){
            visited[i+1][j] = 1;
            answer += BFS(i+1,j);
        }
        if (j+1<M && arr[i][j+1] == 1 && visited[i][j+1] == 0) {
            visited[i][j+1] = 1;
            answer += BFS(i,j+1);
        }
        if (i-1>=0 && arr[i-1][j] == 1 && visited[i-1][j] == 0) {
            visited[i-1][j] = 1;
            answer += BFS(i-1,j);
        }
        if (j-1>=0 && arr[i][j-1] == 1 && visited[i][j-1] == 0) {
            visited[i][j-1] = 1;
            answer += BFS(i,j-1);
        }
        return answer;
    }


}
