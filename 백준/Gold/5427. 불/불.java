
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, X, Y;
    static int[][] arr, visited;
    static Queue<Node325> qS, qF;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[] answerList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        answerList = new int[N];
        for (int i = 0 ; i < N ; i++) {
            X = sc.nextInt();
            Y = sc.nextInt();
            sc.nextLine();
            qS = new LinkedList<>();
            qF = new LinkedList<>();

            arr = new int[Y][X];
            visited = new int[Y][X];

            for (int j = 0 ; j < Y ; j++) {
                char[] str = sc.nextLine().toCharArray();
                for (int k = 0 ; k < X ; k++) {
                    switch (str[k]) {
                        case '#':
                            arr[j][k] = -1;
                            break;
                        case '@':
                            arr[j][k] = 1;
                            qS.add(new Node325(j,k));
                            break;
                        case '*':
                            arr[j][k] = -2;
                            qF.add(new Node325(j,k));
                            break;
                        default:
                            arr[j][k] = 0;
                    }
                }
            }
            answerList[i] = bfs();
        }

        Arrays.stream(answerList).forEach(answer -> {
            if (answer == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(answer);
        });
    }

    public static int bfs() {
        int answer = 0;
        while(!qS.isEmpty() || !qF.isEmpty()) {

            if (qS.isEmpty()) return -1;
            else answer++;

            int lengthOfQF = qF.size();

            for (int i = 0 ; i < lengthOfQF ; i++) {
                Node325 node = qF.poll();
                int y = node.y;
                int x = node.x;

                for (int j = 0 ; j < 4 ; j++) {
                    if (y+dy[j]>=0 && y+dy[j]<Y && x+dx[j]>=0 && x+dx[j]<X) {
                        if (arr[y+dy[j]][x+dx[j]] != -1 && arr[y+dy[j]][x+dx[j]] != -2) {
                            arr[y+dy[j]][x+dx[j]] = -2;
                            qF.add(new Node325(y+dy[j], x+dx[j]));
                        }
                    }
                }
            }

            int lengthOfQS = qS.size();

            for (int i = 0 ; i < lengthOfQS ; i++) {
                Node325 node = qS.poll();
                int y = node.y;
                int x = node.x;
                if (y==0 || y==Y-1 || x==0 || x==X-1) return 1;
                for (int j = 0 ; j < 4 ; j++) {
                    if (y+dy[j]>=0 && y+dy[j]<Y && x+dx[j]>=0 && x+dx[j]<X) {
                        if (arr[y+dy[j]][x+dx[j]] == 0) {
                            if (y+dy[j]==0 || y+dy[j]==Y-1 || x+dx[j]==0 || x+dx[j]==X-1) return answer + 1;
                            arr[y+dy[j]][x+dx[j]] = answer+1;
                            qS.add(new Node325(y+dy[j], x+dx[j]));
                        }
                    }
                }
            }

        }
        return -1;
    }
}

class Node325 {
    int y, x;
    public Node325(int y, int x) {
        this.y = y;
        this.x = x;
    }
}