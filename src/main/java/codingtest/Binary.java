package codingtest;

import java.util.Scanner;

public class Binary {

    public int solution(int N, int answer){
        if(N==0) return 0;
        answer = 10*solution(N/2, answer)+N%2;

        return answer;
    }

    public static void main(String[] args){
        Binary T = new Binary();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        System.out.println(T.solution(N, answer));
    }
}
