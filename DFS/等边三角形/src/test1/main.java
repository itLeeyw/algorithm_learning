package test1;

/***
 * 
 * @author 26218
 *题目:等边三角形
 *有3<=n<=20的木棍(每根木棍都要用到)，例如:有1，2，3，3的4根木棍，它可以让1，2的木棍组成一条边，另外两根木棍组成两条边，则可以组成一个等边三角形
成功则输出yes 反之no

思路: 通过一个f判断是否达到想要结果，如果由于我们是使用每条边合法来判断，所以当num为3时则直接合法，DFS有点像模拟~
 */

import java.util.Scanner;
public class main {
	static int n = 0;
	static int sum = 0;
	static int[] mg = new int[10005];
	static boolean f;
	static boolean[] vis = new boolean[10005];
	static void dfs(int num, int s,int i) {
		if(f) {// 只要成功就退出
			return;
		}
		if(num == 3) {
			f = true;
			return ;
		}
		if(s == sum / 3) { // 一条边一条边的判断
			dfs(num+1, 0, 0);
			return;
		}
		for(int j = i; j < n; j++) {
			if(!vis[j]) {
				vis[j] = true;
				dfs(num, s + mg[j], j+1);
				vis[j] = false;
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			mg[i] = sc.nextInt();
			sum += mg[i];
		}
		if(sum%3 != 0) {
			System.out.println("no");
		}else {
			dfs(0, 0, 0);
			if(f) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		
		
	}

}
