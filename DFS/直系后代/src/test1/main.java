package test1;
import java.util.Scanner;
import java.util.Vector;
import java.lang.NullPointerException;
public class main {

	public class arr{
		Vector<Integer> son = new Vector<Integer>();
		int count = 0;
	}

	static arr[] hash = new arr[10005];//key 为父母，value为子女
	static boolean[] f = new boolean[10005];
	static int[] ans = new int [10005];
	static int dfs(int root) {
		int ret = 0;
		for(int i = 0; i < hash[root].son.size(); i++) {
			ret += dfs(hash[root].son.elementAt(i));
		}
		ans[root] = ret;
		return ret + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n > 1) {
			int x = sc.nextInt(), y = sc.nextInt() ;
			while(1 > x && x > n && 1 > y && y > n) {
				System.out.println("请重新输入数据：");
				x = sc.nextInt();y = sc.nextInt() ;
			}
			//hash[x].count++;
			hash[x].son.add(y);
			f[y] = true;
			n--;
		}
		int root = 0;
		for(int i = 1; i <= n; i++) {
			if(!f[i]) {
				root = i;
				break;
			}
		}
		dfs(root);
		
	}

}
