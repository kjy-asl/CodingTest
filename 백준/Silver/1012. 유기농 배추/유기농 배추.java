

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] result = new int[t];
		
		for(int i=0; i<t; i++) {
			// roop 1
			int count=0;
			String[] setting = br.readLine().split(" ");
	
			int m = Integer.parseInt(setting[0]); // 가로
			int n = Integer.parseInt(setting[1]); // 세로
			int k = Integer.parseInt(setting[2]); // 벌레
			map = new int[n][m];
			
			for(int w = 0; w<k; w++) {
				String[] setting2 = br.readLine().split(" ");
				int col = Integer.parseInt(setting2[0]);
				int row = Integer.parseInt(setting2[1]);
				map[row][col] = 1;
			}
			
			for(int r = 0; r<map.length; r++) {
				for(int c=0; c<map[0].length; c++) {
					if(map[r][c]==1) {
				
						bfs(r, c);
						count++;
					}
				}
			}
			result[i] = count;
		}
		for(int i=0; i<t; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void bfs(int r, int c) {
		int[]dx = {0,0,1,-1};
		int[]dy = {-1,1,0,0};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{r,c});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			map[tmp[0]][tmp[1]]=0;
			for(int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				
				if(0<=nx && nx<map.length && 0<=ny && ny<map[0].length && map[nx][ny]==1) {
					int[] addCol = new int[2];
					addCol[0] = nx;
					addCol[1] = ny;
					queue.add(addCol);
					map[nx][ny] = 0;
				}
			}
		}
	}
	
	public static void printMap() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
