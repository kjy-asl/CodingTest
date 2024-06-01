import java.io.*;

public class Main {
    private static int[] numberArray;
    private static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomNumber = Integer.parseInt(br.readLine());

        numberArray = new int[10];

        while(roomNumber > 0) {
            numberArray[roomNumber%10]++;
            roomNumber = roomNumber/10;
        }
        numberArray[6] = (numberArray[6]+numberArray[9]+1)/2;
//        numberArray[9] = (numberArray[9]+1)/2;

        for (int i = 0 ; i < 9 ; i++) {
            if (numberArray[i]>MAX) {
                MAX = numberArray[i];
            }
        }

        System.out.println(MAX);
    }
}
