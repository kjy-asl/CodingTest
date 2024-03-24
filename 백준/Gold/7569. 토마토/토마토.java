import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int X, Y, Z;
    static int[][][] arr,visited;
    static Queue<Node324> q;
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();
        Z = sc.nextInt();
        sc.nextLine();
        arr = new int[Z][Y][X];
        visited = new int[Z][Y][X];
        int minNum = 0;
        q = new LinkedList<>();
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    arr[i][j][k] = sc.nextInt();
                }
            }
        }

        for (int i = 0; i < Z ; i++) {
            for (int j = 0; j < Y ; j++) {
                for (int k = 0; k < X ; k++) {
                    if (arr[i][j][k] == 1 && visited[i][j][k] == 0) {
                        visited[i][j][k] = 1;
                        q.add(new Node324(j,k,i));
                    }
                }
            }
        }
        bfs();

        if (!checkTomato()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < Z; i++) {
                for (int j = 0; j < Y; j++) {
                    for (int k = 0; k < X; k++) {
                        if(minNum<arr[i][j][k]) minNum = arr[i][j][k];
                    }
                }
            }

            System.out.printf("%d", minNum-1);
        }
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Node324 node = q.poll();
            int z = node.z;
            int y = node.y;
            int x = node.x;
            for (int i = 0 ; i < 6 ; i++) {
                if (z+dz[i]>=0 && z+dz[i]<Z && x+dx[i]>=0 && x+dx[i]<X && y+dy[i]>=0 && y+dy[i]<Y) {
                    if (arr[z+dz[i]][y+dy[i]][x+dx[i]] == 0) {
                        arr[z+dz[i]][y+dy[i]][x+dx[i]] = arr[z][y][x]+1;
                        visited[z+dz[i]][y+dy[i]][x+dx[i]] = 1;
                        q.add(new Node324(y+dy[i],x+dx[i],z+dz[i]));
                    }
                }
            }
        }
    }

    public static boolean checkTomato() {
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if (arr[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}

class Node324 {
    int y, x, z;

    public Node324(int y, int x, int z) {
        this.y = y;
        this.x = x;
        this.z = z;
    }
}