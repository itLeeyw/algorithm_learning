package test4;

/***
 * 题目：有n个人 有n件事，每个人完成n件事的时间不一样且每个人只能完成一件事，求利益最大的话最少需要多长时间
 * 以x == n 为出口，表示每个员工都用到了，然后判断是否为最短时间
 * 通过循环每件事来判断员工做这件事情的时间，再做当前轮时标记为做过，当前轮做过后标记为false即可
 * 
 * 样例输入：
 * 6
   10 11 12 11 9 11 11 9 10 13 11 12 12 10 11 10 13 9 9 14 9 10 10 11 10 10 9 11 12 11 10 7 10 10 10 8
   
   答案为：54
 */
import java.util.Scanner;
public class main {
	static int[][] task = new int[15][15];
	static int n, ans;
	static boolean[] used = new boolean[15];
	static public void dfs(int x, int t) {
		if(x == n) {
			if(t < ans) ans = t;
			return ;
		}
		for(int i = 0; i < n; i++) {
			if(!used[i]) {
				used[i] = true;
				dfs(x + 1, t + task[x][i]);
				used[i] = false;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				task[i][j] = sc.nextInt();
			}
		}
		ans = 20000;
		dfs(0,0);
		System.out.println(ans);
	}

}
