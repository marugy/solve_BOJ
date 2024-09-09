import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		Node pre;
		String data;
		Node next;
		
		Node(Node pre, String data, Node next){
			this.pre = pre;
			this.data = data;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		Node header = new Node(null, "head", null);
		Node tail = new Node(header, "tail", null);
		header.next=tail;
		
		Node cursor =tail;
		
		String[] line = br.readLine().split("");
		for(String str : line) {
			Node node = new Node(cursor.pre, str, cursor);
			cursor.pre.next=node;
			cursor.pre = node;
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
	
			if(command.equals("L")) {
				if(cursor.pre==header) continue;
				cursor = cursor.pre;
			}else if(command.equals("D")) {
				if(cursor==tail) continue;
				cursor=cursor.next;
			}else if(command.equals("B")) {
				if(cursor.pre==header) continue;
				cursor.pre.pre.next=cursor;
				cursor.pre = cursor.pre.pre;
			}else {
				String str = st.nextToken();
				Node node = new Node(cursor.pre, str, cursor);
				cursor.pre.next=node;
				cursor.pre=node;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(header.next!=null) {
			header=header.next;
			if(header==tail)continue;
			sb.append(header.data);
		}
		System.out.print(sb.toString());

	}

}
