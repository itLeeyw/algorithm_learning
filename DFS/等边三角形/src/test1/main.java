package test1;

/***
 * 
 * @author 26218
 *��Ŀ:�ȱ�������
 *��3<=n<=20��ľ��(ÿ��ľ����Ҫ�õ�)������:��1��2��3��3��4��ľ������������1��2��ľ�����һ���ߣ���������ľ����������ߣ���������һ���ȱ�������
�ɹ������yes ��֮no

˼·: ͨ��һ��f�ж��Ƿ�ﵽ��Ҫ������������������ʹ��ÿ���ߺϷ����жϣ����Ե�numΪ3ʱ��ֱ�ӺϷ���DFS�е���ģ��~
 */

import java.util.Scanner;
public class main {
	static int n = 0;
	static int sum = 0;
	static int[] mg = new int[10005];
	static boolean f;
	static boolean[] vis = new boolean[10005];
	static void dfs(int num, int s,int i) {
		if(f) {// ֻҪ�ɹ����˳�
			return;
		}
		if(num == 3) {
			f = true;
			return ;
		}
		if(s == sum / 3) { // һ����һ���ߵ��ж�
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
