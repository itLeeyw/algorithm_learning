package test;

public class main {
	static boolean[][]vis = new boolean[8][8];
	static int ans = 0;
	static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x > 7 || y > 7 || vis[x][y]) {
			return;
		}
		if(x == 7 && y == 7) {
			ans++;
			return;
		}
		vis[x][y] = true;
		dfs(x+1,y);
		dfs(x,y+1);
		vis[x][y] = false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("aaa");
		dfs(0,0);

		System.out.println(ans);
	}

}
