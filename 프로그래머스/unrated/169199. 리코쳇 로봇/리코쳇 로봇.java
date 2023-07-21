import java.util.*;

class Solution {    
/*
    1. char[][]로 게인판 분리
    2. 로봇 위치 뽑기
    3. BFS로 G 위치 찾기
*/
    static int r =0;
    static int c =0;
    static int rX = -1;
    static int rY = -1;
    static char[][]map = null;
    static boolean[][]visited = null;
    static int [][]dir ={{-1,0},{1,0},{0,-1},{0,1}};
    static int step = -1;
    
    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void setGame(String[]board){
        for(int i=0; i<r; i++){
            map[i] = board[i].toCharArray();
            if(rX==-1){
                for(int j=0;j<c;j++){
                    if(map[i][j]=='R'){
                        rX = i;
                        rY = j;
                    }
                }
            }
        }
    }
    
    static void findG(){
        visited[rX][rY] = true;
        Pos start = new Pos(rX,rY);
        Queue<Pos> q = new ArrayDeque<>();
        q.add(start);
        
        int move = 0;
        while(!q.isEmpty()){
            int size = q.size();
            move++;
            while(--size>=0){
                Pos now = q.poll();
                for(int d=0; d<4; d++){
                    //끝까지 이동시키기
                    int xx = now.x;
                    int yy = now.y;
                    
                    int mX = dir[d][0];
                    int mY = dir[d][1];
                    while((0<=xx+mX && xx+mX<r && 0<=yy+mY && yy+mY<c) && map[xx+mX][yy+mY]!='D'){
                        xx+=mX;
                        yy+=mY;
                    }
                    
                    if(visited[xx][yy]) continue;

                    if(map[xx][yy]=='G'){
                        step=move;
                        return;
                    }
                    visited[xx][yy]=true;
                    q.add(new Pos(xx,yy));
                }
            }
        }
    }
    
    public int solution(String[] board) {
        
        r = board.length;
        c = board[0].length();
        
        map = new char[r][c];
        visited = new boolean[r][c];
        
        setGame(board);
        
        findG();
        
        return step;
    }
}