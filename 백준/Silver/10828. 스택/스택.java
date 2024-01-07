import java.util.Scanner;

public class Main {

    public static int[] stack; // 동적 할당을 위한 포인터 배열?
    public static int size = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = input.nextInt();

        stack = new int[N]; // 동적할당 -> 해제는 언제 하는가?

        for(int i = 0; i<N; i++){
            String str = input.next();

            switch (str){

                case "push":
                    push(input.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int item){
        stack[size] = item;
        size++;
    }

    public static int pop(){
        if (size == 0){
            return -1;
        }
        int res = stack[size-1];
        stack[size-1] = 0;
        size--;
        return res;
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size==0){
            return 1;
        }
        return 0;
    }

    public static int top(){
        if(size == 0){
            return -1;
        }
        return stack[size - 1];
    }
}