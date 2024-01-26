package codingtest;

import java.util.Scanner;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}

public class DFS {


    public int solution(int N){

        return 0;
    }

    public static void main(String[] args){
        DFS T = new DFS();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(T.solution(N));
    }
}
