package test;

/***
 * @time 2019-11-4
 * @author 26218
 * 
 * ��Ŀ:
 һ��R*C�������ϰ�����ˮ����#�����Ե� .�������Ե�
 ���г��ĵ���ֻ�������Եģ��������ͨ����ˮ��������
 *
 *
 *�ѵ㣺����String�����������char��ά���飬��ͨ��next()�����ж��룬next()��nextLine()����
 *next()�������ܵõ����ո���ַ���
 *nextLine()�����
 *��ͨ������ѭ������ÿһ���ڵ��жϺ������������
 *���ڼ���Ŀ
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
