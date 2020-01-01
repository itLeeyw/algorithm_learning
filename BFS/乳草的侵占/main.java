/**
 * @题目 草地被分割成 X * Y (1 <= X,Y <= 100)的直角网络。左下角格子为(1,1)
 * 乳草一开始占领格为(Mx, My)
 * 每周乳草向四周扩散(没有石头的地方)
 * 一周后，新乳草也可以继续扩散
 * 如果乳草在0时刻处于(Mx, My) 那么在那个时刻可以完全占领农场？
 * '.' 表示草，'*' 表示石头
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class main {
 
	static int n, m, v, u;
	static char[][] map = new char[110][110];
	static boolean[][] vis = new boolean[110][110];
	static int[][] cnt=new int[110][110];
	static int[] dx = { 1, -1, 0, 0, -1, 1, -1, 1 };
	static int[] dy = { 0, 0, 1, -1, 1, 1, -1, -1 };
 
	static int bfs() {
		vis[u][v] = true;
		cnt[u][v]=0;
		Queue<M> q = new LinkedList<>();
		q.offer(new M(u, v));
		int ma = -1;
		while (!q.isEmpty()) {
			u = q.peek().x;
			v = q.peek().y;
			q.poll();
			for (int i = 0; i < 8; i++) {
				int x = u + dx[i];
				int y = v + dy[i];
				if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == '.' && !vis[x][y]) {
					q.offer(new M(x,y));
					map[x][y]='*';
					cnt[x][y]=cnt[u][v]+1;
                    // System.out.println(cnt[x][y]);
                    vis[x][y]=true;
					ma=Math.max(cnt[x][y], ma);
				}
			}
		}
		return ma;
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		v = sc.nextInt() - 1;// 几何坐标到数组坐标的映射：（x，y）-->（n-(y+1),x）
		u = sc.nextInt() - 1;
		u = n - u - 1;
		for (int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}
		int t=bfs();
		System.out.println(t);
	}
 
}
 
class M {
	int x, y;
 
	public M() {
 
	}
 
	public M(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
