package stairs;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 39;
		int n = taijie(num);
		System.out.println(n);
	}
	
	/**
	 * 题目要求:第一脚为左脚，最后一脚为右脚，中间过程左右交替
	 * 
	 * 解题关键 ，一步到位
	 * 1级台阶 左脚方法为1，右脚方法为0
	 * 2级台阶 左脚方法为1，右脚方法为1
	 * 3级台阶 左脚方法为1，右脚方法为2
	 * 4级台阶 左脚方法为3，右脚方法为2
	 * @param n
	 * @return
	 */
	
	public static int taijie(int n) {
		int[] left = new int[41];
		int[] right = new int[41];
		int j;
		left[1]=1;//1级台阶时 最后一只脚为左脚的方法为1 
		left[2]=1;//2级台阶时 最后一只脚为左脚的方法为1 
		right[1]=0;//1级台阶时 最后一只脚为右脚的方法为0 
		right[2]=1;//2级台阶时 最后一只脚为右脚的方法为1
		for(j=3;j<=40;j++)
		{
		  left[j]=right[j-1]+right[j-2];//左脚等于前两项右脚方法之和 
		  right[j]=left[j-1]+left[j-2];	//右脚等于前两项左脚方法之和
		}
		return right[n];//题目要求返回的是最后一只脚为右脚的方法数 


	}

}
