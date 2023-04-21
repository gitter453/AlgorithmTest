package codeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
http://mir.mincoding.co.kr/enterprise/contest/miracom/279/problem/02
https://blog.naver.com/cih468/221670953951
커밋 2023-04-03
*/
public class Main2 {

	public static void main(String[] args) {
		
		try {
			File file = new File("C:/Users/JOE/eclipse-workspace/codeTest/src/inputs/input.txt");
			
			
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
			
			StringTokenizer st = new StringTokenizer(bReader.readLine());
			int T = Integer.parseInt(st.nextToken()); //테스트케이스
			
			System.out.println("테스트케이스 T :"+T);
			
			for (int i = 0; i < T ; i++) {
				
				st = new StringTokenizer(bReader.readLine());
			
				
				int N = Integer.parseInt(st.nextToken()); //맵의사이즈
				int M = Integer.parseInt(st.nextToken()); //터널의 갯수
			
				System.out.println("맵의사이즈 N :"+N);
				System.out.println("터널의 갯수 M :"+M);
				
				int [][] arr = new int [N][N]; //맵생성
				
				for (int j = 0; j < N ; j++) {
					st = new StringTokenizer(bReader.readLine());
					for (int k = 0; k < N ; k++) {
						arr[j][k] = Integer.parseInt(st.nextToken()); 
						//System.out.println("j : "+j+", k : "+k +" => "+arr[j][k]);
						System.out.print(arr[j][k]+" ");
					}
					System.out.println();
				}
				
				//int [][] tunnel = new int [M][2];//터널정보생성
				
				int [][] tunnels = new int [M][2];
				int gas = 0;
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
					
					gas = Integer.parseInt(st.nextToken());
				}
				
				//st = new StringTokenizer(bReader.readLine());
				System.out.println("터널연료소모량 :"+gas);
				System.out.println("출발점높이 :"+arr[0][0]);
				System.out.println("도착점높이 :"+arr[N-1][N-1]); 
				System.out.println("=========================["+(i+1)+"]테스트케이스 입력 종료========================");
				System.out.println("");
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
