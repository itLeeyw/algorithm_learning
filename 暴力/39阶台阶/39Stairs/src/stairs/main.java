package stairs;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 39;
		int n = taijie(num);
		System.out.println(n);
	}
	
	/**
	 * ��ĿҪ��:��һ��Ϊ��ţ����һ��Ϊ�ҽţ��м�������ҽ���
	 * 
	 * ����ؼ� ��һ����λ
	 * 1��̨�� ��ŷ���Ϊ1���ҽŷ���Ϊ0
	 * 2��̨�� ��ŷ���Ϊ1���ҽŷ���Ϊ1
	 * 3��̨�� ��ŷ���Ϊ1���ҽŷ���Ϊ2
	 * 4��̨�� ��ŷ���Ϊ3���ҽŷ���Ϊ2
	 * @param n
	 * @return
	 */
	
	public static int taijie(int n) {
		int[] left = new int[41];
		int[] right = new int[41];
		int j;
		left[1]=1;//1��̨��ʱ ���һֻ��Ϊ��ŵķ���Ϊ1 
		left[2]=1;//2��̨��ʱ ���һֻ��Ϊ��ŵķ���Ϊ1 
		right[1]=0;//1��̨��ʱ ���һֻ��Ϊ�ҽŵķ���Ϊ0 
		right[2]=1;//2��̨��ʱ ���һֻ��Ϊ�ҽŵķ���Ϊ1
		for(j=3;j<=40;j++)
		{
		  left[j]=right[j-1]+right[j-2];//��ŵ���ǰ�����ҽŷ���֮�� 
		  right[j]=left[j-1]+left[j-2];	//�ҽŵ���ǰ������ŷ���֮��
		}
		return right[n];//��ĿҪ�󷵻ص������һֻ��Ϊ�ҽŵķ����� 


	}

}
