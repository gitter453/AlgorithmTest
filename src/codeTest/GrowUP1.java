package codeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GrowUP1 {

 
		//L R U D 좌 우 상 하
		private static int[] nextX= {0,0,1,-1}; //로봇의 이동방향 우 좌
		private static int[] nextY= {1,-1,0,0}; //로봇의 이동방향 상 하	
		private static boolean [][] visit;
		private static int[] trees; 
		private static int N;
		private static int M;
		private static int day;
		
		public static void main(String[] args) {
			
			try {
				File file = new File("C:/Users/JOE/eclipse-workspace/codeTest/src/codeTest/input1.txt");
				
				FileReader fReader = new FileReader(file);
				BufferedReader bReader = new BufferedReader(fReader);
				
				StringTokenizer st = new StringTokenizer(bReader.readLine());
				int T = Integer.parseInt(st.nextToken()); //테스트케이스
				
				System.out.println("테스트케이스 T :"+T);
				
				for (int i = 0; i < T ; i++) {
					
					st = new StringTokenizer(bReader.readLine());
					N = Integer.parseInt(st.nextToken()); //나무갯수 
					System.out.println("나무갯수 N :"+N);
					
					trees = new int [N]; 
					
					st = new StringTokenizer(bReader.readLine());
					
					for (int j = 0; j < N ; j++) { 
						//String tmp =  st.nextToken() ;
						//System.out.print("tmp :: "+tmp+" ");
						trees[j]=Integer.parseInt(st.nextToken());
						System.out.print(trees[j]+" ");
					}
					
					System.out.println();

					Arrays.sort(trees);
					System.out.println("Sorted arr[] : " + Arrays.toString(trees));
					int day=0;
					int shorTree = trees[0];
					int longTree = trees[N-1];
					
					System.out.println("제일 작은 나무 : "+shorTree);

					System.out.println("제일 큰 나무 : "+longTree);
					
					int diff = longTree - shorTree;
					
					if(diff==0) {
						
					}else  if(diff==1) {
						trees[0]=odd(shorTree);
					}else if(diff==2) {
						trees[0]=even(shorTree);
					}else{
						
					}
					
					System.out.println();
					
					System.out.println(day+" 만에 나무 키우기 종료!");
					
 					System.out.println("============["+(i+1)+"]테스트케이스 입력 종료========"); 
					
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			

		}

		public static int odd(int treelength) {
			
			day= day+1;
			treelength = treelength+1;
			return treelength;
		
		}
		
		public static int even(int treelength) {
			day= day+2;
			treelength = treelength+2;
			return treelength;
		} 
}
