package test4;

/***
 * ��Ŀ����n���� ��n���£�ÿ�������n���µ�ʱ�䲻һ����ÿ����ֻ�����һ���£����������Ļ�������Ҫ�೤ʱ��
 * ��x == n Ϊ���ڣ���ʾÿ��Ա�����õ��ˣ�Ȼ���ж��Ƿ�Ϊ���ʱ��
 * ͨ��ѭ��ÿ�������ж�Ա������������ʱ�䣬������ǰ��ʱ���Ϊ��������ǰ����������Ϊfalse����
 * 
 * �������룺
 * 6
   10 11 12 11 9 11 11 9 10 13 11 12 12 10 11 10 13 9 9 14 9 10 10 11 10 10 9 11 12 11 10 7 10 10 10 8
   
   ��Ϊ��54
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
