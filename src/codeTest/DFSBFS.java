package codeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSBFS {

	static int h, w;
	static int map[][];
	static int dirty;
	static int ans;
	static int mini;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int[][] dis;
	static ArrayList<Cd> starCd;
	static ArrayList<Integer> dfsList;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("C:/Users/JOE/eclipse-workspace/codeTest/src/inputs/input.txt"));

		Scanner sc = new Scanner(System.in);

		while (true) {

			w = sc.nextInt();

			h = sc.nextInt();

			mini = 10000;

			if (w == 0 && h == 0)
				return;

			int startX = 0;
			int startY = 0;
			dirty = 1;

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				String inString = sc.next();
				for (int j = 0; j < w; j++) {

					map[i][j] = inString.charAt(j);

					if (map[i][j] == 'o') {
						startX = i;
						startY = j;
						map[i][j] = '.';
					}

					if (map[i][j] == '*') {
						dirty++;
					}
				}
			}
			
			dis = new int[dirty][dirty];

			ans = 0;
			
			int starNum = 1;
			starCd = new ArrayList<>();
			starCd.add(new Cd());
			
			//bfs 0
			Queue<Cd> queue = new LinkedList<>();
			
			queue.add(new Cd(startX,startY,0));
			
			boolean visit[][] = new boolean[h][w];
			
			while(!queue.isEmpty()) {
				Cd crt = queue.remove();
			
				int x = 0;
				int y = 0;
				for(int i=0;i<4;i++) {
					x = crt.x + dx[i];
					y = crt.y + dy[i];
					
					try {
						if(map[x][y]!='x' && !visit[x][y]) {
							if(map[x][y]=='*') {
								map[x][y] = starNum;
							
								dis[0][starNum] = crt.move+1;
									
								starNum++;
								starCd.add(new Cd(x,y,0));
								
							}
							
							visit[x][y] = true;
							queue.add(new Cd(x,y,crt.move+1));
						}
					} catch (Exception e) {
						continue;
						// TODO: handle exception
					}
					
				}
				
			}
			
			if(starNum==dirty) {
				
				for(int i=1;i<dirty-1;i++) {
						bfs(i);
					}
				
				dfsList = new ArrayList<>();
				
				dfsList.add(0);
				
				dfs(1,0);			

				System.out.println(mini);

				
			}
				
			else
				System.out.println(-1);
		}

	}
	
	public static void dfs(int depth,int sum) {
		
		if(depth==dirty) {
			mini = Math.min(sum, mini);
			return ;
		}
		
		for(int i=1;i<dirty;i++) {
			
			int bef = dfsList.get(dfsList.size()-1);
			
			if(dfsList.contains(i))
				continue;
			
			dfsList.add(i);
			
			dfs(depth+1,sum+dis[bef][i]);
			
			dfsList.remove(dfsList.size()-1);
		}
		
	}
	
	public static void bfs(int star1) {
		
		//bfs
		Queue<Cd> queue = new LinkedList<>();
		
		queue.add(new Cd(starCd.get(star1).x,starCd.get(star1).y,0));
		
		boolean visit[][] = new boolean[h][w];
		
		//star1+1번부터 dirty-1까지 찾아야 하므로 총
		int find= dirty - 1 - (star1+1) +1;
		
		while(!queue.isEmpty()) {
			Cd crt = queue.remove();
		
			int x = 0;
			int y = 0;
			for(int i=0;i<4;i++) {
				x = crt.x + dx[i];
				y = crt.y + dy[i];
				
				try {
					if(map[x][y]!='x' && !visit[x][y]) {
						if(map[x][y]>star1 && map[x][y] < 11) {
						
							dis[star1][map[x][y]] = crt.move+1;
							dis[map[x][y]][star1] = crt.move+1;
								
							find--;
							visit[x][y] = true;
							
							if(find==0)
								return;
						}
						
						visit[x][y] = true;
						queue.add(new Cd(x,y,crt.move+1));
					}
				} catch (Exception e) {
					continue;
					// TODO: handle exception
				}
				
			}
			
		}
		
	}


}

class Cd {
	int x;
	int y;
	int move;

	public Cd(int x, int y,int move) {
		super();
		this.x = x;
		this.y = y;
		this.move = move;
	}

	public Cd() {
		super();
		// TODO Auto-generated constructor stub
	}
} 

