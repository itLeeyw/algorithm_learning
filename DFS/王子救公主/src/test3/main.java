package test3;
import java.util.Scanner;
/***
 * 
 * @author 26218
 *题目：再一个n*m的城堡中，w代表王子，g代表公主，#代表墙壁，.代表可通，王子一次走两步，公主一次走一步，问王子能否救到公主(是否再某个点能相遇)
 */
public class main {
	static int n, m;
	static String[]mp = new String[105];
	static boolean [][][]vis = new boolean[105][105][2];
	static void dfs(int x, int y, int d) {
		if(x < 0 || y < 0 || x >= n || y >= m || vis[x][y][d] || mp[x].charAt(y) == '#') return;
		vis[x][y][d] = true;
		dfs(x - (2 - d), y, d);
		dfs(x + (2 - d), y, d);
		dfs(x, y - (2 - d), d);
		dfs(x, y + (2 - d), d);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		for(int i = 0; i < n; i++) {
			mp[i] = sc.next();
		}
		int x=0, y=0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(mp[i].charAt(j) == 'w') {
					x = i;
					y = j;
				}
		dfs(x, y, 0);
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(mp[i].charAt(j) == 'g') {
					x = i;
					y = j;
				}
		dfs(x, y, 1);
		boolean ans = false;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(vis[i][j][0] && vis[i][j][1]) {
					ans = true;
				}
		if(ans) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

}
