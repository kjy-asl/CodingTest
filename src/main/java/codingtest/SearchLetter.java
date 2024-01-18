package codingtest;


import java.util.Scanner;

public class SearchLetter {

    public int solution(String str, char c){
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);
        for(int i = 0 ; i<str.length() ; i++){
            if(str.charAt(i)==c){ answer++; }
        }

        return answer;
    }

    public static void main(String[] args){
        SearchLetter T = new SearchLetter();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);

        System.out.print(T.solution(str, c));
    }
}
