package test;

/***
 * ��Ŀ������Ŀ�ļ���ʾ
 */
import java.util.Scanner;
public class main {
	static int n, m;
	static boolean ok;
	static void dfs(long x, int cnt) {
		if( ok ) return ;// �����Լ�֦�����ҵ�һ����û��Ҫ�����������
		if( cnt >= 19 ) return ;// �ݹ����
		if( x % n == 0) {// �ݹ���ڣ��������ж�
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
