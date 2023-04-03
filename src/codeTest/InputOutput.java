package codeTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class InputOutput {
	
	//좌표크래스
	static class Node {
		
		int r ; 
		int c ; 
		int cnt ;//연료 
		
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static int[] dr= {0,0,1,-1}; //로봇의 이동방향 우 좌
	private static int[] dc= {1,-1,0,0}; //로봇의 이동방향 상 하	
	private static int[] go= {0,0,0,0}; 
	private static Queue<Node> queue;
	private static boolean [][] visit; 
	private static int[][] map;
	private static int[][] distance;
	private static int N;
	private static int M; 
	
	public static void main(String[] args) {
		
		try {
			/*
			 * File file = new
			 * File("C:/Users/JOE/eclipse-workspace/codeTest/src/codeTest/input.txt");
			 * 
			 * 
			 * FileReader fReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fReader);
			 */
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		    
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()); //테스트케이스
			
			System.out.println("테스트케이스 T :"+T+"개");
			
			for (int i = 0; i < T ; i++) {
				System.out.println("테스트케이스 i "+i);
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
						System.out.print(map[j][k]+" ");
					}
					System.out.println();
				}
				 				
				/*
				 * int [][] tunnels = new int [M][2]; int [] shortGas = new int [M]; int
				 * spentGas = 0;
				 */
				
				for (int j = 0; j < M ; j++) { //터널갯수만큼 반복
					
					/*
					 * int [] tunnelfrom = new int [2]; int [] tunnelto = new int [2];
					 */
					System.out.println("터널정보 ~");
					System.out.println(br.readLine().toString());
					System.out.println("~터널정보" );
					/*
					 * tunnelfrom[0] = Integer.parseInt(st.nextToken()); tunnelfrom[1] =
					 * Integer.parseInt(st.nextToken()); tunnelto[0] =
					 * Integer.parseInt(st.nextToken()); tunnelto[1] =
					 * Integer.parseInt(st.nextToken()); spentGas =
					 * Integer.parseInt(st.nextToken());
					 * 
					 * System.out.println("tunnelfrom : "+Arrays.toString(tunnelfrom));
					 * System.out.println("tunnelto : "+Arrays.toString(tunnelto));
					 * 
					 * System.out.println("spentGas : "+spentGas);
					 */
				}
				
				System.out.println("출발점높이 :"+map[0][0]);
				System.out.println("도착점높이 :"+map[N-1][N-1]); 
				System.out.println("=========================["+(i)+"]테스트케이스 입력 종료========================");
				System.out.println("");
				

				System.out.println("bfs 시작=====>"+bfs());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

	public static int bfs() {
			
		Queue<Node> q = new LinkedList<Node>();
		boolean [][] visited = new boolean[N][N];
		
		q.offer(new Node(0,0,0));
		visited[0][0]=true;

		while(!q.isEmpty()) {
			
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int cnt = curr.cnt;
			
			if(r == N-1 && c == N-1) {
				System.out.println("curr.r, curr.c => ["+curr.r+","+curr.c+"] curr.cnt => "+curr.cnt);
				//System.out.println(map[r][c]);
				return cnt;
			}
			
			for (int d = 0; d <4 ; d++) {
				int nr = r +dr[d];
				int nc = c +dc[d];
				
				if(nr<0 || nc <0 || nr >=N ||nc >=N)
					continue;
				
				if(visited[nr][nc])
					continue;
				
				
				/*
				 * if (map[r][c] > map[nr][nc]) { //현재위치의 높이가 더 높을 경우 //oil 0; }else if
				 * (map[r][c] < map[nr][nc]) {//현재위치의 높이가 더 낮을 경우 cnt =
				 * cnt+(map[nr][nc]-map[r][c])*2; }else { //현재위치와 다음위치의 높이가 같을 경우 cnt = cnt+1; }
				 */
				
				//System.out.println("다음 갈 좌표 :"+nr+","+nc +" 소비한연료:"+cnt);
				//cnt = cnt+1;
				int oil = 0;

				
				if (map[r][c] < map[nr][nc]) { //낮=>높
					oil = (map[nr][nc]-map[r][c]) * 2;
				}else if(map[r][c] > map[nr][nc]){ //높=>낮
					//oil = 0;
				}else {
					oil = 1;
				}
				System.out.println("현재:"+r+","+c +"=> 다음:"+nr+","+nc+" curr.cnt: "+curr.cnt+" , oil:"+oil); 
				q.offer(new Node(nr,nc,oil+curr.cnt));
				visited[nr][nc] = true;
				//System.out.println("nr => "+nr+", nc => "+nc+", cnt+1 => "+cnt+1);
			}
		}
		return 0;
		 	
	}

}
