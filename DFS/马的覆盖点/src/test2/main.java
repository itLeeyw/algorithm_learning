package test2;

import java.util.Scanner;

/***
 * 
 * @author 26218
 *题目: 在初始为n*m的全部为.的棋盘上，初始点为x,y的马 再三步之内所有能走的点
 *与迷宫类似，但此时多了一个判断条件为step，当step>3时则越界为出口条件
 *以及多了一个“染”，将合格条件置为'#'
 */

public class main {
	static char[][]mp = new char[105][105];
	static boolean[][] vis = new boolean[105][105];
	static int n,m;
	static int[][] dir = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
	static void dfs(int x, int y, int step) {
		if(step > 3) return;
		if(x < 0 || y < 0 || x >= n || y >= m) return;
		mp[x][y] = '#';
		for(int i = 0; i < 8; i++) {
			dfs(x+dir[i][0], y+dir[i][1], step+1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		int x = sc.nextInt(), y = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				mp[i][j] = '.';
			}
		}
		
		dfs(x-1, y-1, 0);
		for(int i = 0; i < n; i++) {
				System.out.println(mp[i]);
		}
	}

}
