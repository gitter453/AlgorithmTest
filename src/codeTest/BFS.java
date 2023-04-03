package codeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	
	//좌표크래스
	static class Point {
		
		int x ; 
		int y ; 
		int z ;//연료 
		
		public Point (int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	private static int[] NEW_X= {0,0,1,-1}; //로봇의 이동방향 우 좌
	private static int[] NEW_Y= {1,-1,0,0}; //로봇의 이동방향 상 하	
	private static Queue<Point> queue;
	private static int[][] map;
	private static int N;
	private static int M;
	private static int totalGas;
	private static boolean [][] visit;
	private static int [][] distance;
	
	public static void main(String[] args) {
		
		try {
			File file = new File("C:/Users/JOE/eclipse-workspace/codeTest/src/codeTest/input.txt");
			
			
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
			
			StringTokenizer st = new StringTokenizer(bReader.readLine());
			int T = Integer.parseInt(st.nextToken()); //테스트케이스
			
			System.out.println("테스트케이스 T :"+T);
			
			for (int i = 0; i < T ; i++) {
				
				st = new StringTokenizer(bReader.readLine());
			
				N = Integer.parseInt(st.nextToken()); //맵의사이즈
				M = Integer.parseInt(st.nextToken()); //터널의 갯수
			
				System.out.println("맵의사이즈 N :"+N);
				System.out.println("터널의 갯수 M :"+M);
				
				map = new int [N][N]; //맵생성
				visit = new boolean [N][N]; //방문기록
				
				for (int j = 0; j < N ; j++) {
					st = new StringTokenizer(bReader.readLine());
					for (int k = 0; k < N ; k++) {
						map[j][k] = Integer.parseInt(st.nextToken()); 
						//System.out.println("j : "+j+", k : "+k +" => "+arr[j][k]);
						System.out.print(map[j][k]+" ");
					}
					System.out.println();
				}
				
				//int [][] tunnel = new int [M][2];//터널정보생성
				
				int [][] tunnels = new int [M][2];
				int [] shortGas = new int [M];
				int spentGas = 0;
				
				for (int j = 0; j < M ; j++) { //터널갯수만큼 반복
					
					int [] tunnelfrom = new int [2];
					int [] tunnelto = new int [2];
					
					st = new StringTokenizer(bReader.readLine());
					
					tunnelfrom[0] = Integer.parseInt(st.nextToken());
					tunnelfrom[1] = Integer.parseInt(st.nextToken());
					tunnelto[0] = Integer.parseInt(st.nextToken());
					tunnelto[1] = Integer.parseInt(st.nextToken());
					//tunnels[M] = tunnel;
					

					System.out.println("tunnelfrom : "+Arrays.toString(tunnelfrom));
					System.out.println("tunnelto : "+Arrays.toString(tunnelto));
					
					//spentGas[M] = Integer.parseInt(st.nextToken());
				}
				
				System.out.println("출발점높이 :"+map[0][0]);
				System.out.println("도착점높이 :"+map[N-1][N-1]); 
				System.out.println("=========================["+(i+1)+"]테스트케이스 입력 종료========================");
				System.out.println("");
				
				
				//출발점 무조건 0,0
				//도착점 무조건 N-1,N-1

				System.out.println("bfs 시작!!!" );
				bfs(0,0,0);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

	public static int bfs(int x, int y, int z) {
			
		visit[x][y]= true;
		queue = new LinkedList<>();
		queue.add(new Point(x,y,z));
		
		while(!queue.isEmpty()) {
			
			Point temp = queue.poll();//하나 꺼내
			
			if(temp.x == N-1 && temp.y==N-1) {
				System.out.println("oil TOTAL: " +z);
				break;
			}
			
			for(int i=0; i < 4; i++) {
				
				int new_x = temp.x+NEW_X[i]; 
				int new_y = temp.y+NEW_Y[i];
				
				
				if(new_x>=0 && new_y>=0 && new_x<N && new_y<N) { //맵 사이즈 안에서만 돌기
					
					if(!visit[new_x][new_y]) {
						
						visit[new_x][new_y]= true;
						
						if (map[temp.x][temp.y] > map[new_x][new_y]) { //현재위치의 높이가 더 높을 경우
							//oil 0;
						}else if (map[temp.x][temp.y] < map[new_x][new_y]) {//현재위치의 높이가 더 낮을 경우
							z = z+(map[new_x][new_y]-map[temp.x][temp.y])*2;
						}else { //현재위치와 다음위치의 높이가 같을 경우 
							z = z+1;
						}
						
						System.out.println("다음 갈 좌표 :"+new_x+","+new_y +" 소비한연료:"+z);
						queue.add(new Point(new_x,new_y,z));
						
					}
					 
				}
				
			}
			
		}
	
	return 0;	
	}

}
