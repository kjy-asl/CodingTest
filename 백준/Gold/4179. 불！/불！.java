
import java.util.*;

public class Main {
    static int[][] map, visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node320> qFire;
    static Queue<Node320> qJ;
    static int N,M;

    public static void main(String[] args) {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        map = new int[N][M];
        visited = new int[N][M];
        qJ = new LinkedList<Node320>();
        qFire = new LinkedList<>();

        for (int i = 0 ; i < N ; i++) {
            String str = scanner.nextLine();
            for (int j = 0 ; j < M ; j++) {
                char temp = str.toCharArray()[j];
                switch(temp) {
                    case '#':
                        map[i][j] = -1;
                        break;
                    case 'J':
                        map[i][j] = 1;
                        qJ.add(new Node320(i,j));
                        break;
                    case 'F':
                        map[i][j] = -2;
                        qFire.add(new Node320(i,j));
                        break;
                    default:
                        map[i][j] = 0;
                }
            }
        }

        m.BFS();
    }

    public boolean BFS() {
        int answer = 0;
        while (!qFire.isEmpty() || !qJ.isEmpty()) {
            answer++;
            int fireSize = qFire.size();
            for (int k = 0 ; k < fireSize ; k++) {
                Node320 currentNode320 = qFire.poll();
                int y = currentNode320.y;
                int x = currentNode320.x;

                for (int i = 0 ; i < 4 ; i++) {
                    if (y+dy[i] >= 0 && y+dy[i] < N && x+dx[i] >= 0 && x+dx[i] < M) {
                        if ((map[y+dy[i]][x+dx[i]] == 1 || map[y+dy[i]][x+dx[i]] == 0)) {
                            map[y+dy[i]][x+dx[i]] = -2;
                            visited[y+dy[i]][x+dx[i]] = 1;
                            qFire.add(new Node320(y+dy[i], x+dx[i]));
                        }
                    }
                }
            }
            int jSize = qJ.size();
            for (int k = 0 ; k < jSize ; k++) {
                Node320 currentNode320 = qJ.poll();
                int y = currentNode320.y;
                int x = currentNode320.x;
                if (y==0 || y==N-1 || x==0 || x==M-1){
                    System.out.println(answer);
                    return true;
                }
                for (int i = 0; i < 4 ; i++) {
                    if (y+dy[i] >= 0 && y+dy[i] < N && x+dx[i] >= 0 && x+dx[i] < M) {
                        if (y+dy[i] == 0 || y+dy[i] == N-1 || x+dx[i] == 0 || x+dx[i] == M-1){
                            if (map[y+dy[i]][x+dx[i]] == 0) {
                                answer++;
                                System.out.println(answer);
                                return true;
                            }
                        }
                        if (map[y+dy[i]][x+dx[i]]==0) {
                            map[y+dy[i]][x+dx[i]] = 1;
                            visited[y+dy[i]][x+dx[i]]=1;
                            qJ.add(new Node320(y+dy[i], x+dx[i]));
                        }
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
        return false;
    }

    static class Node320 {
        int y,x;

        public Node320(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}