package codingtest;

import java.util.List;
import java.util.Scanner;

public class BOJ {

    public int solution(int[][] numbers){
        int answer = 0;
        int N = numbers.length;
        int[][] dy = new int[N][3];
        dy[0][0]=numbers[0][0];
        dy[0][1]=numbers[0][1];
        dy[0][2]=numbers[0][2];

        for(int i=1;i< N;i++){
            dy[i][0] = numbers[i][0]+Math.min(dy[i-1][1], dy[i-1][2]);
            dy[i][1] = numbers[i][1]+Math.min(dy[i-1][0], dy[i-1][2]);
            dy[i][2] = numbers[i][2]+Math.min(dy[i-1][0], dy[i-1][1]);
        }

        answer = Math.min(Math.min(dy[N-1][0], dy[N-1][1]), dy[N-1][2]);

        return answer;
    }

    public static void main(String[] args){
        BOJ T = new BOJ();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] Cost = new int[N][3];

        for(int i=0;i<N;i++){
            Cost[i][0]=sc.nextInt();
            Cost[i][1]=sc.nextInt();
            Cost[i][2]=sc.nextInt();
        }

        System.out.println(T.solution(Cost));
    }
}
