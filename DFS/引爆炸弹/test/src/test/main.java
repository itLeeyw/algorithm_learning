package test;


/***
 * ��һ�� n �� m �ķ����ͼ�ϣ�ĳЩ�����Ϸ�����ը�����ֶ�����һ��ը���Ժ�ը�����ը�����ڵ��к����ϵ�����ը����������������ը��������������ը��������������ȥ.
����Ϊ��������ͼ�ϵ�����ը������Ҫ�ֶ���������һЩը����Ϊ�˰�Σ�ճ̶Ƚ�����ͣ�����������ֶ��������ٸ�ը�����԰ѵ�ͼ�ϵ�����ը��������
 *��
 *
��������
5 5
00010
00010
01001
10001
01000

���Ϊ��2
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
