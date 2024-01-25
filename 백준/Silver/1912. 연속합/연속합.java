import java.util.Scanner;

public class Main {

    public int solution(int[] arr){
        int answer = 0;
        int[] dy = new int[arr.length];
        dy[0]= arr[0];
        answer = arr[0];
        for (int i = 1; i<arr.length; i++){
            if (dy[i-1] < 0){
                dy[i] = arr[i];
            }
            else{
                dy[i] = dy[i-1]+arr[i];
            }

            if (answer<dy[i]) answer = dy[i];
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i =0; i<N ;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}