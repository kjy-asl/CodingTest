
import java.util.*;

public class Main {
    static int[] arr = new int[26];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (char c : input.toCharArray()){
            arr[c-'a']++;
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
