package test_dhhmzmzh;

/***
 * ��Ŀ:
����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 *˼·��
 *          2
 *   a      b      c
 * d e f  d e f  d e f
 * 
 * ʹ���������������ɵó����н����ͨ��combinningString���ַ��������,ǰ�����
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class main {
	
	/**
	 * 
	 * @param str ��ǰ��������Ӧ���ַ���
	 * @param index ͨ�������������ɵ��ַ��������±� ��ʼֵΪ0
	 * @param list ���list�����ϸ��£���ֹ����Ϊ
	 * @param temp �м��������¼�����һ�������ַ����ַ��� ��ʼֵΪ""
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
		System.out.print("��������Ҫ��ϵ�����");
		String digits = sc.nextLine();
		List<String>list = letterCombinations(digits);
		System.out.println("��Ͻ��Ϊ:");
		for(String item : list) {
			System.out.print(item+" ");
		}
	}

}
