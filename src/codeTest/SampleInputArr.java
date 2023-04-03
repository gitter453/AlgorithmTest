package codeTest;

import java.io.*;
import java.util.StringTokenizer;

public class SampleInputArr { 
	
	public static void main(String[] args) throws IOException{


	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//입력 예시
	//3 4 (height x width)
	//1 2 3 4
	//4 3 4 1
	//5 5 5 1
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	int height = Integer.parseInt(st.nextToken());
	int width= Integer.parseInt(st.nextToken());
	
		int[][] arr = new int[height][width];
		for (int y = 0; y < height; y++) {
		st = new StringTokenizer(br.readLine());
		for (int x = 0; x < width; x++) {
		arr[y][x] = Integer.parseInt(st.nextToken());
		}
	}

	br.close();
	bw.close();
	}
}