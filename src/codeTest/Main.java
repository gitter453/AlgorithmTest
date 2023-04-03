package codeTest;

import java.awt.Point;
import java.io.*;
import java.util.*;
 
public class Main {

	class BFSNode {
		final int moveCount;
		final int posX;
		final int posY;

		public BFSNode(int moveCount, int posX, int posY) {
			this.moveCount = moveCount;
			this.posX = posX;
			this.posY = posY;
		}
	}


	final int useTestCase = 1;

	int curTestCase = 1;
	int maxTestCase = 1;

	final int max = 0x3fffffff;
	final int[] dx = {0,0,1,-1}; //로봇의 이동방향 우 좌
	final int[] dy = {1,-1,0,0}; //로봇의 이동방향 상 하	
	 
	int mapSize;
	int[][] map;
	int[][] dp;

	Point nightPos;
	Point dstPos;

	void bfs() {
		for (int y = 0; y < mapSize; y++) {
			Arrays.fill(dp[y], max);
		}

		dp[nightPos.y][nightPos.x] = 0;

		Queue<BFSNode> bfsQueue = new LinkedList<>();
		bfsQueue.add(new BFSNode(0, nightPos.x, nightPos.y));

		while (!bfsQueue.isEmpty()) {
			BFSNode node = bfsQueue.poll();

			int curX = node.posX;
			int curY = node.posY;
			int curMoveCount = node.moveCount;

			// 이동횟수가 더 크면 무시한다.
			if (curMoveCount > dp[curY][curX]) {
				continue;
			}

			for (int i = 0; i < 8; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				int nextMoveCount = curMoveCount + 1;

				// 맵 범위 벗어나면 무시
				if (nextX < 0 || nextX >= mapSize ||
					nextY < 0 || nextY >= mapSize) {
					continue;
				}

				if (nextMoveCount < dp[nextY][nextX]) {
					dp[nextY][nextX] = nextMoveCount;
					bfsQueue.add(new BFSNode(nextMoveCount, nextX, nextY));
				}
			}
		}
	}

	void solve() throws Exception {
		mapSize = nextInt();
		nightPos = new Point(nextInt(), nextInt());
		dstPos = new Point(nextInt(), nextInt());
		map = new int[mapSize][mapSize];
		dp = new int[mapSize][mapSize];

		bfs();

		println(dp[dstPos.y][dstPos.x]);
	}

	void main() throws Exception {
		if (useTestCase == 1) {
			maxTestCase = nextInt();
		}

		while (curTestCase <= maxTestCase) {
			solve();
			curTestCase++;
		}
	}

	/* ======================================================================
	 * 입력 관련 템플릿 코드
	 * ====================================================================== */
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringTokenizer stringTokenizer;

	private static void print(String s) {
		try {
			bufferedWriter.append(s);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getStackTrace());
		}
	}

	private static void println(Integer i) {
		println(i.toString());
	}

	private static void println(String s) {
		print(s + "\n");
	}

	private static String next() {
		while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
			try {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stringTokenizer.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	/* ====================================================================== END */

	public static void main(String[] args) throws Exception {
		new Main().main();
		bufferedWriter.flush();
		bufferedReader.close();
	}
}