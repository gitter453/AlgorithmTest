package codeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import codeTest.BFS2.Node;
 
public class DFS {
	
	//좌표크래스
	static class Point {
		
		int x ; 
		int y ; 
		int z ;
		
		public Point (int x, int y, int z ) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	//L R U D 좌 우 상 하
	private static int[] nextX= {0,0,1,-1}; //로봇의 이동방향 우 좌
	private static int[] nextY= {1,-1,0,0}; //로봇의 이동방향 상 하	
	private static boolean [][] visit;
	private static int[][] map;
	private static int[][] distance;
	private static int N;
	private static int M;
	private static int oil;
	
	public static void main(String[] args) {
		
		try {
			File file = new File("C:/Users/JOE/eclipse-workspace/codeTest/src/inputs/input.txt");
			
			FileReader fReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fReader);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()); //테스트케이스
			
			System.out.println("테스트케이스 T :"+T);
			
			for (int i = 0; i < T ; i++) {
				
				st = new StringTokenizer(br.readLine());
			
				N = Integer.parseInt(st.nextToken()); //맵의사이즈
				M = Integer.parseInt(st.nextToken()); //터널의 갯수
			
				System.out.println("맵의사이즈 N :"+N);
				System.out.println("터널의 갯수 M :"+M);
				
				map = new int [N][N]; //맵생성
				distance = new int [N][N]; //맵생성
				visit = new boolean [N][N]; //방문기록
				
				for (int j = 0; j < N ; j++) {
					st = new StringTokenizer(br.readLine());
					for (int k = 0; k < N ; k++) {
						map[j][k] = Integer.parseInt(st.nextToken()); 
						visit[j][k] = false;
						System.out.print(map[j][k]+" ");
					}
					System.out.println();
				}
				
				for (int j = 0; j < M ; j++) { //터널갯수만큼 반복
					
					int [] tunnelfrom = new int [2];
					int [] tunnelto = new int [2];
					
					st = new StringTokenizer(br.readLine());
					
					tunnelfrom[0] = Integer.parseInt(st.nextToken());
					tunnelfrom[1] = Integer.parseInt(st.nextToken());
					tunnelto[0] = Integer.parseInt(st.nextToken());
					tunnelto[1] = Integer.parseInt(st.nextToken());
					

					//System.out.println("tunnelfrom : "+Arrays.toString(tunnelfrom));
					//System.out.println("tunnelto : "+Arrays.toString(tunnelto));
				}
				
				System.out.println("출발점높이 :"+map[0][0]);
				System.out.println("도착점높이 :"+map[N-1][N-1]); 
				System.out.println("=========================["+(i+1)+"]테스트케이스 입력 종료========================");
				System.out.println("");
				
				
				//출발점 무조건 0,0
				//도착점 무조건 N-1,N-1
				System.out.println("dfs 시작!!!" );
				oil=0;
				visit[0][0]=true;
				
				System.out.println("result:"+dfs(0,0) ); 
				System.out.println("=========================["+(i+1)+"]테스트케이스 출력 종료========================");

			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

	public static int dfs(int x, int y) {
		
 
		//System.out.println("for 시작");
		for(int i = 0 ; i <4 ; i++) {
			int newX = x + nextX[i];
			int newY = y + nextY[i];
			
			if(newX==N-1&&newY==N-1) {
			oil = distance[x][x];
			System.out.println("("+newX+","+newY+") "+distance[newX][newY]);
			
			}
			if (newX >= 0 && newY >= 0 && newX < N && newY < N ) {
				
			
				if(visit[newX][newY]==false) {
					
					
					/*
					 * if (map[x][y] > map[newX][newY]) { //현재위치의 높이가 더 높을 경우 //소모된연료 0; }else if
					 * (map[x][y] < map[newX][newY]) {//현재위치의 높이가 더 낮을 경우 gas =
					 * gas+(map[newX][newY]-map[x][y])*2; }else { //현재위치와 다음위치의 높이가 같을 경우 gas =
					 * gas+1; }
					 */				
					
					//gas=gas+1;
	
					visit[newX][newY]=true;
					distance[newX][newY]=distance[x][y]+1;
					//System.out.println("dfs x,y : ("+x+","+ y +") => ("+newX+","+newY+") gas : "+distance[newX][newY]);
					dfs(newX,newY);
				}
			}
		}
		
		return oil;
		
	}
 
	
	

}
