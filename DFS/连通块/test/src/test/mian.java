package test;

/***
 * @time 2019-11-4
 * @author 26218
 * 
 * 题目:
 一个R*C的桌子上摆满了水果，#代表爱吃的 .代表不爱吃的
 且切出的蛋糕只包含爱吃的，求最大连通爱吃水果的数量
 *
 *
 *难点：定义String类型数组替代char二维数组，再通过next()来进行读入，next()和nextLine()区别
 *next()方法不能得到带空格的字符串
 *nextLine()则可以
 *后通过二重循环来对每一个节点判断后进行搜索即可
 *属于简单题目
 */

import java.util.Scanner;
public class mian {
	static int ans = 0, max = 0;
	static String[] mp = new String[1000];
	static int n,m;
	static boolean[][] vis = new boolean[1000][1000];
	static int[][] step = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m || vis[x][y] || mp[x].charAt(y) == '.') {
			return;
		}
		vis[x][y] = true;
		ans++;
		for(int i = 0; i < 4; i++) {
			dfs(x+step[i][0],y+step[i][1]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i = 0; i < n; i++)
			mp[i] = sc.next(); 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!vis[i][j] && mp[i].charAt(j) != '.') {
					ans = 0;
					dfs(i,j);
					if(ans > max) {
						max = ans;	
					}
				}
			}
		}
		sc.close();
		System.out.println(max);
		System.out.println("hello world");
	}

}
