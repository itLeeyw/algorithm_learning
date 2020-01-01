import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main{

	static class Node{
		int []num=new int[4];
		int ans;
		Node(int a,int b,int c,int d,int ans){
			this.num[0]=a;
			this.num[1]=b;
			this.num[2]=c;
			this.num[3]=d;
			this.ans=ans;
		}
		Node(){
			ans=0;
		}
	}
	static int[][][][] vis=new int[11][11][11][11];
	static int add(int a) {
		if(a==9) {
			a=1;
		}else {
			a++;
		}
		
		return a;
	}
	static int sub(int a) {
		if(a==1) {
			a=9;
		}else {
			a--;
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer token=new StringTokenizer(br.readLine());
		String begin=br.readLine();
		String pwd=br.readLine();
		Node first=new Node();
		Node last=new Node();
		for(int i=0;i<4;i++) {
			first.num[i]=begin.charAt(i)-'0';
			last.num[i]=pwd.charAt(i)-'0';
		}
		vis[first.num[0]][first.num[1]][first.num[2]][first.num[3]]=1;
		Queue<Node> q=new LinkedList<Node>();
		Node p;
		p=first;
		q.add(first);
	//	int min=0x3f3f3f3f;
		while(!q.isEmpty()) {
			p=q.poll();
			if(p.num[0]==last.num[0]&&p.num[1]==last.num[1]&&p.num[2]==last.num[2]&&p.num[3]==last.num[3]) {
				System.out.println(p.ans);
				return;
			}
			
			for(int i=0;i<4;i++) {
				Node next=new Node(p.num[0],p.num[1],p.num[2],p.num[3],p.ans);
				next.num[i]=add(next.num[i]);
				if(vis[next.num[0]][next.num[1]][next.num[2]][next.num[3]]==0) {
					vis[next.num[0]][next.num[1]][next.num[2]][next.num[3]]=1;
					next.ans++;
					q.add(new Node(next.num[0],next.num[1],next.num[2],next.num[3],next.ans));
				}
			}
			
			for(int i=0;i<4;i++) {
				
				Node next=new Node(p.num[0],p.num[1],p.num[2],p.num[3],p.ans);
				next.num[i]=sub(next.num[i]);
				if(vis[next.num[0]][next.num[1]][next.num[2]][next.num[3]]==0) {
					vis[next.num[0]][next.num[1]][next.num[2]][next.num[3]]=1;
					next.ans++;
					q.add(new Node(next.num[0],next.num[1],next.num[2],next.num[3],next.ans));
				}
			}
			
			for(int i=0;i<3;i++) {
				Node next=new Node(p.num[0],p.num[1],p.num[2],p.num[3],p.ans);
				int temp=next.num[i+1];
				next.num[i+1]=next.num[i];
				next.num[i]=temp;
				if(vis[next.num[0]][next.num[1]][next.num[2]][next.num[3]]==0) {
					vis[next.num[0]][next.num[1]][next.num[2]][next.num[3]]=1;
					next.ans++;
					q.add(new Node(next.num[0],next.num[1],next.num[2],next.num[3],next.ans));
				}
			}
		}
	}
}

