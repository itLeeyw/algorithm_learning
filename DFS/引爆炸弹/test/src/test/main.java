package test;


/***
 * 在一个 n × m 的方格地图上，某些方格上放置着炸弹。手动引爆一个炸弹以后，炸弹会把炸弹所在的行和列上的所有炸弹引爆，被引爆的炸弹又能引爆其他炸弹，这样连锁下去.
现在为了引爆地图上的所有炸弹，需要手动引爆其中一些炸弹，为了把危险程度降到最低，请算出最少手动引爆多少个炸弹可以把地图上的所有炸弹引爆。
 *、
 *
输入样例
5 5
00010
00010
01001
10001
01000

结果为：2
 */
import java.util.Scanner;
public class main {
	static int n, m, ant ;
	static String[] mp = new String[1005];
	static boolean[] row = new boolean[1005];
	static boolean[] col = new boolean[1005];
	static public void dfs(int x, int y) {
		StringBuilder strBuilder = new StringBuilder(mp[x]);
		strBuilder.setCharAt(y, '0');
		mp[x] = strBuilder.toString();
		
		if( !row[x] ) {
			row[x] = true;
			for(int i = 0; i < m; i++) {
				if(mp[x].charAt(i) == '1') {
					dfs(x, i);
				}
			}
		}
		
		if( !col[y] ) {
			col[y] = true;
			for(int i = 0; i < n; i++) {
				if(mp[i].charAt(y) == '1') {
					dfs(i, y);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i = 0; i < n; i++) {
			mp[i] = sc.next();
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				if(mp[i].charAt(j) == '1') {
					ant++;
					dfs(i, j);
				}
			}
		System.out.println(ant);
	}

}
