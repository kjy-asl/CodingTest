package codingtest;

import java.util.Scanner;

public class FlipSpecificLetter {

    public String solution(String str){
        String answer = "";
        char[] characters = str.toCharArray();
        int lt = 0, rt = str.length()-1;

        while(lt<rt){
            char tmp;
            if (Character.isAlphabetic(characters[lt]) &&
            Character.isAlphabetic(characters[rt])){
                tmp = characters[lt];
                characters[lt] = characters[rt];
                characters[rt] = tmp;
            }
            lt++;
            rt--;
            answer = String.valueOf(characters);
        }

        return answer;
    }

    public static void main(String[] args){
        FlipSpecificLetter T = new FlipSpecificLetter();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.print(T.solution(str));
    }
}
