package test1;

import java.util.Scanner;
public class main {
	static boolean[] vis = new boolean[105];
	static int[] jg = new int[105];
	static int cnt, n;
	static void dfs(int i, int num) {
		if(i == n) {
			System.out.println(num);
			return;
		}
		for(int j = 1; j <= n; j++) {
			if(!vis[j]) {
				vis[j] = true;
				dfs(i+1, num*10+j);
				vis[j] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans = 1;
		for(int i = 1; i <= n; i++) {
			ans *= i;
		}
		System.out.println(ans);
		dfs(0, 0);
	}

}
