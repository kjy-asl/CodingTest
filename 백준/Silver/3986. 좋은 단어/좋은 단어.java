import java.util.*;
import java.io.*;
public class Main {
    static Stack<Character> charStack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            charStack = new Stack<>();
            for (int j = 0 ; j < str.length() ; j++) {
                if (charStack.isEmpty()) {
                    charStack.push(str.charAt(j));
                } else {
                    Character c = charStack.pop();
                    if (str.charAt(j) == c) {
                        continue;
                    }
                    else {
                        charStack.push(c);
                        charStack.push(str.charAt(j));
                    }
                }
            }
            if (charStack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
