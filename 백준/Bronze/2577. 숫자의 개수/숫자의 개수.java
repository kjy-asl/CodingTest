
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] numberArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int num = A*B*C;
        numberArray = new int[10];
        while(num > 0) {
            numberArray[num%10]++;
            num = num/10;
        }
        for ( int i = 0 ; i < 10 ; i++) {
            System.out.println(numberArray[i]);
        }
    }
}
