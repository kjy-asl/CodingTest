
import java.util.*;

public class Main {
    static int[] arr = new int[9];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        for (char c : String.valueOf(input).toCharArray()) {
            if (c == '9') arr[6]++;
            else {arr[c-'0']++;}
        }
        arr[6] = (int) Math.ceil((double) arr[6]/2.0);
        int answer = Arrays.stream(arr).max().orElse(0);
        System.out.println(answer);
    }


}
