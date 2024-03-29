import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main {
    static int[][] arr;
    static boolean[] visited;

    private void dfs(int V){
        if(!visited[V]){
            visited[V] = true;
            System.out.print(V + " ");
        }
        for ( int i = 1 ; i < arr.length ; i++) {
            if ( arr[V][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    private void bfs(int V){
        if(!visited[V]){
            visited[V] = true;
            System.out.print(V + " ");
        }
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(V);


        while(!que.isEmpty()){
            Integer node = que.poll();
            for ( int i = 1 ; i < arr.length ; i++) {
                if (arr[node][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        arr = new int[N+1][N+1];
        for (int i =0 ; i <M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N+1];
        T.dfs(V);

        System.out.println();

        visited = new boolean[N+1];
        T.bfs(V);
    }
}
