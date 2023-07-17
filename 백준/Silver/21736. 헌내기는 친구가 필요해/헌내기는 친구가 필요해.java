import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][]campus = null;
    static int doX=-1;
    static int doY=-1;
    static int[][]dir = {{0,-1},{0,1},{1,0},{-1,0}};
    static boolean[][]visited = null;
    static int cnt = 0;

    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static void findHu(){
        Queue<Pos> q = new ArrayDeque<>();
        visited[doX][doY]=true;
        q.add(new Pos(doX,doY));

        while(!q.isEmpty()){
            int size = q.size();
            while(--size>=0){
                Pos now = q.poll();
                for(int d=0;d<4;d++){
                    int xx = now.x + dir[d][0];
                    int yy = now.y + dir[d][1];

                    if(!(0<=xx && xx<N && 0<=yy && yy<M)) continue;

                    if(!visited[xx][yy] && campus[xx][yy]!='X'){
                        visited[xx][yy]=true;
                        q.add(new Pos(xx,yy));
                        if(campus[xx][yy]=='P'){
                            cnt++;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            campus[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++){

                if(doX!=-1) continue;
                if(campus[i][j]=='I'){
                    doX = i;
                    doY = j;
                }
            }
        }
        findHu();
        if(cnt==0){
            System.out.println("TT");
        }else{
            System.out.println(cnt);
        }
    }
}
