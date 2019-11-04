package test1;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n>1) {
			int x = sc.nextInt(), y = sc.nextInt() ;
			while(1 <= x && x <= n && 1 <= y && y <= n) {
				System.out.println("请重新输入数据：");
				x = sc.nextInt();y = sc.nextInt() ;
			}
			n--;
		}
	}

}
