package test_dhhmzmzh;

/***
 * 题目:
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 *思路：
 *          2
 *   a      b      c
 * d e f  d e f  d e f
 * 
 * 使用深度优先搜索便可得出所有结果，通过combinningString对字符进行组合,前序遍历
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class main {
	
	/**
	 * 
	 * @param str 当前数字所对应的字符串
	 * @param index 通过输入数字生成的字符串数组下标 初始值为0
	 * @param list 结果list，不断更新，终止条件为
	 * @param temp 中间变量，记录非最后一个变量字符的字符串 初始值为""
	 * @return
	 */
	private static List<String> combinningString(String []str,int index,List<String> list,String temp) {
		if (index == str.length - 1) {
	          for (int i = 0; i < str[index].length(); i++) {
	              list.add(temp + str[index].charAt(i));
	          }
	      } else {
	          for (int i = 0; i < str[index].length(); i++) {
	       	   combinningString(str, index + 1, list, temp + str[index].charAt(i));
	          }
	      }
		return list;
	}
	
	
	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		String [] s = new String[digits.length()];
		if(s.length == 0) return list;
		for(int i = 0; i < s.length; i++) {
			switch (digits.charAt(i)) {
				case '2': s[i]="abc"; break;
				case '3': s[i]="def"; break;
				case '4': s[i]="ghi"; break;
				case '5': s[i]="jkl"; break;
				case '6': s[i]="mno"; break;
				case '7': s[i]="pqrs"; break;
				case '8': s[i]="tuv";  break;
				case '9': s[i]="wxyz"; break;
			}
		}
		list = combinningString(s, 0, list, "");
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入你要组合的数：");
		String digits = sc.nextLine();
		List<String>list = letterCombinations(digits);
		System.out.println("组合结果为:");
		for(String item : list) {
			System.out.print(item+" ");
		}
	}

}
