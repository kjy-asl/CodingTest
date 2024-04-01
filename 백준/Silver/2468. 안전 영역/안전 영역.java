

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int[][] binaryMap, visited;
    static Queue<Node401> q;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        int max = 0;
        int answerMax = 0 ;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j]>max) max = map[i][j];
            }
        }
        q = new LinkedList<>();
        for (int i = 0 ; i <= max ; i++) {
            binaryMap = new int[N][N];
            visited = new int[N][N];
            int answer = 0;
            for (int j = 0 ; j < N ; j++) {
                for (int k = 0 ; k < N ; k++) {
                    if (map[j][k] <= i) {
                        binaryMap[j][k] = 0;
                    } else {
                        binaryMap[j][k] = 1;
                    }
                }
            }
            for (int j = 0 ; j < N ; j++) {
                for (int k = 0 ; k < N ; k++) {
                    if (binaryMap[j][k] == 1 && visited[j][k] == 0) {
                        answer++;
                        q.add(new Node401(j,k));
                        visited[j][k] = 1;
                        bfs();
                    }
                }
            }

            if (answerMax < answer) answerMax = answer;
        }
        System.out.println(answerMax);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Node401 node = q.poll();
            int y = node.y;
            int x = node.x;

            for (int i = 0 ; i < 4 ; i++) {
                if (y+dy[i]>=0 && y+dy[i]<N && x+dx[i]>=0 && x+dx[i]<N) {
                    if (binaryMap[y+dy[i]][x+dx[i]] == 1 && visited[y+dy[i]][x+dx[i]]==0) {
                        q.add(new Node401(y+dy[i], x+dx[i]));
                        visited[y+dy[i]][x+dx[i]] = 1;
                    }
                }
            }
        }
    }
}

class Node401 {
    int x, y;
    public Node401(int y, int x) {
        this.y = y;
        this.x = x;
    }
}