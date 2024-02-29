import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    static void dfs(int[][]maps, int x, int y, int cnt){
        if(x == maps.length-1 && y== maps[0].length-1){
            if(answer>cnt) answer = cnt;
            return;
        }
        for(int i=0;i<4;i++){
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            
            if(!(0<=dx && dx < maps.length && 0<=dy && dy<maps[0].length) || visited[dx][dy] || maps[dx][dy]==0) continue;
            visited[dx][dy]=true;
            dfs(maps,dx,dy,cnt+1);
            visited[dx][dy]=false;
        }
    }
    
    static class Pos{
        int x, y;
        Pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static void bfs(int[][]maps, int x, int y){
        
        Deque<Pos> que = new ArrayDeque<>();
        que.add(new Pos(x,y));
        
        while(!que.isEmpty()){
            int size = que.size();
            while(--size>=0){
                Pos now = que.poll();
                for(int i=0;i<4;i++){
                    int dx = now.x + dir[i][0];
                    int dy = now.y + dir[i][1];
                    if(!(0<=dx && dx < maps.length && 0<=dy && dy<maps[0].length) || visited[dx][dy] || maps[dx][dy]==0) continue;
                    visited[dx][dy]=true;
                    maps[dx][dy]=maps[now.x][now.y]+1;
                    que.add(new Pos(dx,dy));
                }
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        // visited[0][0]=true;
        // dfs(maps,0,0,1);
        // if(answer==Integer.MAX_VALUE) return -1;
        // return answer;
        bfs(maps,0,0);
        if(maps[maps.length-1][maps[0].length-1] >= maps.length+maps[0].length-1) return maps[maps.length-1][maps[0].length-1];
        return -1;
    }
}