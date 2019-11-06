package test;

/***
 * 
 * @author 26218
 *题目: 经典八皇后问题，使用DFS 开搜
 *
 *思路: 八皇后某个点的两条对角线，“丿”的和相同，“捺”的差值相同，用此作为对角线只能存在一个皇后的判定条件
 *其中数组大小一定要经过思考，要比题目稍微大一点，免得不必要的麻烦。
 *
 */

public class main {
	static boolean[]col = new boolean[10];
	static boolean[] x1 = new boolean[20], x2 = new boolean[20];
	static int ans = 0;
	static public boolean confirm(int r, int i) {
		return !col[i] && !x1[r+i] && !x2[r-i+8];
	}
	static public void dfs(int r){
		if(r == 8) {
			ans++;
			return;
		}
		
		for(int i = 0; i < 8; i++) {
			
			if( confirm(r,i) ) {
				col[i] = x1[r+i] = x2[r-i+8] = true;
				dfs(r+1);
				col[i] = x1[r+i] = x2[r-i+8] = false;
			}
		}
	}
	
	static public void main(String[] args) {
		// TODO Auto-generated constructor stub
		dfs(0);
		System.out.println(ans);
	}
}
