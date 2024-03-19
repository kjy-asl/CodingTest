
import java.util.*;

public class Main {
    static int[] arr = new int[10];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArr = new int[3];
        for (int i = 0 ; i < 3 ; i++) {
            intArr[i] = scanner.nextInt();
        }
        String str = String.valueOf(intArr[0]*intArr[1]*intArr[2]);
        for (char c : str.toCharArray()) {
            arr[c-'0']++;
        }
        for (int num : arr) {
            System.out.println(num);
        }
    }


}
