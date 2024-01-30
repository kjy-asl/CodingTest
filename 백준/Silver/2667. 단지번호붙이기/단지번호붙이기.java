import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int count = 0;
    private int solution(int i, int j){
        visited[i][j] = true;
        int answer = 1;
        if ( j - 1 >= 0 && map[i][j-1] == 1 && !visited[i][j-1] ) {  // search left
            answer += solution(i,j-1);
        }
        if ( j + 1 < map.length && map[i][j+1] == 1 && !visited[i][j+1] ) { // search right
            answer += solution(i,j+1);
        }
        if ( i + 1 < map.length && map[i+1][j] == 1 && !visited[i+1][j] ) { // search down
            answer += solution(i+1,j);
        }
        if ( i - 1 >= 0 && map[i-1][j] == 1 && !visited[i-1][j] ) { // search up
            answer += solution(i-1,j);
        }


        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        map = new int[N][N];
        for ( int i = 0 ; i < N ; i++ ) {
            String input = sc.next();
            for ( int j = 0 ; j < N ; j++ ) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];

        for ( int i = 0 ; i < N ; i++ ) {
            for ( int j = 0 ; j < N ; j++) {
                if ( map[i][j] == 1 && !visited[i][j] ) {
                    arr.add(T.solution(i,j));
                    count++;
                }
            }
        }

        Collections.sort(arr);
        System.out.println(count);
        for ( int num : arr ) {
            System.out.println(num);
        }
    }
}
