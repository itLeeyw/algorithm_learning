package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> listAll = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		// 排序
		Arrays.sort(candidates);
		find(listAll, list, candidates, target, 0);
		return listAll;
	}

	public static void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
		// 递归的终点
		if (target == 0) {
			listAll.add(tmp);
			return;
		}
		if (target < candidates[0])
			return;
		
		for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
			// 拷贝一份，不影响下次递归
			List<Integer> list = new ArrayList<>(tmp);
			list.add(candidates[i]);
			// 递归运算，将i传递至下一次运算是为了避免结果重复。
			find(listAll, list, candidates, target - candidates[i], i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] candidates = { 1, 2, 3, 4 };
		System.out.println("请输入目标数");
		int target = sc.nextInt();
		combinationSum(candidates, target);
	}
}
