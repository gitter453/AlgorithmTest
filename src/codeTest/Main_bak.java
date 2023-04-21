package codeTest;

import java.io.*;
import java.util.StringTokenizer;

public class Main_bak {
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 */
				
		try {
			String filepath = "C:/Users/JOE/eclipse-workspace/codeTest/src/inputs/input.txt";
			
			FileInputStream fileStream = new FileInputStream(filepath);
			
			byte [] readBuffer = new byte[fileStream.available()];
			while (fileStream.read(readBuffer) != -1) {}
			
			String txtout = new String (readBuffer);
			System.out.println(txtout);
			//BufferedReader br = new BufferedReader(new InputStreamReader(fist));
			
			fileStream.close();
			
			
		StringTokenizer st = new StringTokenizer(txtout);
		System.out.println("st:"+txtout);
		
		/*
		 * int height = Integer.parseInt(st.nextToken()); int width =
		 * Integer.parseInt(st.nextToken()); int[][] arr = new int [height][width];
		 * 
		 * for (int y=0; y < height ; y++) { st = new StringTokenizer(br.readLine());
		 * for (int x = 0; x < width ; x++) { arr[y][x] =
		 * Integer.parseInt(st.nextToken()); } }
		 */
		
		//br.close();
		//bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		};
		
		
	}

}
