package test;


/* **
 * 题目：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author 26218
 *
 *DP的三个重要概念
 *最优子结构：dp[i - 1] + nums[i] 
 *边界：sum不能小于0
 *状态转移方程 dp[i] = max{nums[i], nums[i]+dp[i-1]}
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
