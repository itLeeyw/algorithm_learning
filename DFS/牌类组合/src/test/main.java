package test;

/***
 * 
��������

С�����ٳֵ�X�ĳǣ�����������3�����ơ�
һ���˿��ƣ�ȥ����С���ƣ���52�ţ������ȷ���4���ˣ�ÿ����13�š�
��ʱ��С��������ͻȻð��һ�����⣺
��������ǻ�ɫ��ֻ���ǵ�����Ҳ�������Լ��õ����Ƶ��Ⱥ�˳���Լ��������õ��ĳ�ʼ�������һ���ж������أ�

 * ˼·�����:�Ƶ����࣬ÿ������0~4�֣�������ܺ�Ϊ13��count++
 * @author 26218
 *
 */

public class main {
	static int count = 0;
	public static void dfs(int type, int sum){
		if(sum > 13) return;
		if(type == 13) {
			if(sum == 13) count++;
			return;
		}
		for(int i = 0; i < 5; i++) {
			dfs(type+1, sum+i);
		}
	}
	
	public static void main(String[] args) {
		dfs(0, 0);
		System.out.println(count);
	}
	
}
