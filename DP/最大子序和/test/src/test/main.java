package test;


/* **
 * ��Ŀ������һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * @author 26218
 *
 *DP��������Ҫ����
 *�����ӽṹ��dp[i - 1] + nums[i] 
 *�߽磺sum����С��0
 *״̬ת�Ʒ��� dp[i] = max{nums[i], nums[i]+dp[i-1]}
 *
 */
public class main {
	 static public int maxSubArray(int[] nums) {
	        int sum = 0, max = nums[0];
	        for(int num : nums){
	            if(sum > 0) sum += num;
	            else sum = num;
	            max = Math.max(sum, max);
	            
	        }
			return max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

}
