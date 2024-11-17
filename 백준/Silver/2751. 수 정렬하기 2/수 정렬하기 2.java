
import java.io.*;
import java.util.*;



public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbBuilder = new StringBuilder();
		int number = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<number; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		list.forEach((e) -> sbBuilder.append(e).append("\n"));
		System.out.println(sbBuilder);
	}
}
	
	
