package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_16235_나무재테크 {

	static int N;
	static int M;
	static int K;
	static int[][]map;
	static int[][]s2d2;
	static Deque<Tree> trees = new ArrayDeque<>();
	static Queue<Tree> death = new ArrayDeque<>();
	static int[][]dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
	
	static class Tree implements Comparator<Tree>{
		int r;
		int c;
		int age;
		Tree(int r, int c, int age) {
			this.r =r;
			this.c =c;
			this.age =age;
		}
		@Override
		public int compare(Tree a, Tree b) {
			return b.age-a.age;
		}
	}
	//시간이 흐르고~
	static void takeTime() {
		for(int season = 0; season < K; season++) {
			spring();
			summer();
			fall();
			winter();
		}
	}
	static void spring() {
		for(int t = 0; t< trees.size();) {
			Tree tree = trees.poll();
			if(map[tree.r][tree.c] >= tree.age) {
				map[tree.r][tree.c]-=tree.age;
				tree.age++;
				trees.add(tree);
				t++;
			}else {
				death.add(tree);
			}
		}
	}
	static void summer() {
		while(!death.isEmpty()) {
			Tree tree = death.poll();
			map[tree.r][tree.c] += tree.age/2;
		}
	}
	
	static void fall() {
		Queue<Tree> q = new ArrayDeque<>();
		for (Tree t : trees) {
			if(t.age%5==0)
				q.add(t);
		}
		while(!q.isEmpty()) {
			Tree tree = q.poll();
			for(int i=0;i<8;i++) {
				int rr = tree.r + dir[i][0];
				int cc = tree.c + dir[i][1];
				if( 0 <= rr && rr < N && 0 <= cc && cc< N) {
					trees.addFirst(new Tree(rr,cc,1));
				}
			}
		}
		
//		for(int t = 0; t<trees.size(); t++) {
//			Tree tree = trees.get(t);
//			if(tree.age%5!=0) continue; //5배수 아니면 생략
//			for(int i=0;i<8;i++) {
//				int rr = tree.r + dir[i][0];
//				int cc = tree.c + dir[i][1];
//				if( 0 <= rr && rr < N && 0 <= cc && cc< N) {
//					trees.add(new Tree(rr,cc,1));
//				}
//			}
//		}
	}
	static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]+=s2d2[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		s2d2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				s2d2[i][j]=Integer.parseInt(st.nextToken());
				map[i][j]=5;
			}
		}
		// 나무 추가
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x,y,z));
		}
		//실행
		takeTime();
		//살아있는 나무 수 출력
		System.out.println(trees.size());
	}
}