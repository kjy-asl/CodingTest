package codingtest;

import java.util.ArrayList;
import java.util.Scanner;

public class ReversingWord {

    public ArrayList<String> solution(int N, String[] str){
        ArrayList<String> answer = new ArrayList<>();

        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args){
        ReversingWord T = new ReversingWord();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        for(int i =0 ; i<N ; i++){
            str[i] = sc.next();
        }
        for(String x : T.solution(N, str)){
            System.out.println(x);
        }
    }
}
