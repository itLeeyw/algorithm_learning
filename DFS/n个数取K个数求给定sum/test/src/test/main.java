package test;
/***
 * 
 * @author 26218
 *��Ŀ: ����n��������Ҫ��ѡ��K������ʹ��ѡ������K�����ĺ�Ϊsum
 */
import java.util.Scanner;
public class main {
	static int n, K, sum, c = 0;
	static int[] nums = new int[105];
	static public void dfs(int i, int k, int ans) {
		if(i == n) {
			if(ans == sum && k == K) {
				c++;
				System.out.println("�ɹ����");
			}
			return;
		}
		
		dfs(i+1, k, ans);
		dfs(i+1, k+1, ans + nums[i]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		K = sc.nextInt();
		sum = sc.nextInt();
		for(int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		dfs(0, 0, 0);
	}

}
