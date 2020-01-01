package test;

/***
 * 题目：如项目文件所示
 */
import java.util.Scanner;
public class main {
	static int n, m;
	static boolean ok;
	static void dfs(long x, int cnt) {
		if( ok ) return ;// 最优性剪枝，已找到一个解没必要继续向后搜索
		if( cnt >= 19 ) return ;// 递归出口
		if( x % n == 0) {// 递归出口，可行性判断
			ok = true;
			System.out.println(x);
			return ;
		}
		dfs( x * 10 + 0, cnt+1);
		dfs( x * 10 + 1, cnt+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(1,0);
	}

}
