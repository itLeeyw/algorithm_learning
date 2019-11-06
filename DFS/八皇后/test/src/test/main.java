package test;

/***
 * 
 * @author 26218
 *��Ŀ: ����˻ʺ����⣬ʹ��DFS ����
 *
 *˼·: �˻ʺ�ĳ����������Խ��ߣ���د���ĺ���ͬ�����ࡱ�Ĳ�ֵ��ͬ���ô���Ϊ�Խ���ֻ�ܴ���һ���ʺ���ж�����
 *���������Сһ��Ҫ����˼����Ҫ����Ŀ��΢��һ�㣬��ò���Ҫ���鷳��
 *
 */

public class main {
	static boolean[]col = new boolean[10];
	static boolean[] x1 = new boolean[20], x2 = new boolean[20];
	static int ans = 0;
	static public boolean confirm(int r, int i) {
		return !col[i] && !x1[r+i] && !x2[r-i+8];
	}
	static public void dfs(int r){
		if(r == 8) {
			ans++;
			return;
		}
		
		for(int i = 0; i < 8; i++) {
			
			if( confirm(r,i) ) {
				col[i] = x1[r+i] = x2[r-i+8] = true;
				dfs(r+1);
				col[i] = x1[r+i] = x2[r-i+8] = false;
			}
		}
	}
	
	static public void main(String[] args) {
		// TODO Auto-generated constructor stub
		dfs(0);
		System.out.println(ans);
	}
}
