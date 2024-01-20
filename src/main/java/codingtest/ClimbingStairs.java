package codingtest;

import java.util.Scanner;

public class ClimbingStairs {

    public int solution(int N){
        int answer = 0;
        int[] dy = new int[N+1];
        dy[1]=1;
        dy[2]=2;
        for (int i =3; i<=N; i++){
            dy[i] = dy[i-2]+dy[i-1];
        }
        answer = dy[N];

        return answer;
    }

    public static void main(String[] args){
        ClimbingStairs T = new ClimbingStairs();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(T.solution(N));
    }
}
