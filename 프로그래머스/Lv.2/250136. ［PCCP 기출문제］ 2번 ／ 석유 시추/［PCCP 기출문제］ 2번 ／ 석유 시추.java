import java.util.*;

class Solution {
    
    static int [][]dir = {{-1,0},{1,0},{0,1},{0,-1}};
    static int h;
    static int w;
    static int[][]oilLand;
    static boolean [][]visited;
    static int []oil;
    static int maxOil = 1;
    
    
    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
    
    public static void bfs(int i, int j){
        
        int oilSize = 1;
        Set<Integer> set = new HashSet<>();
        set.add(j);
        Deque<Pos> que = new ArrayDeque<>();
        visited[i][j]=true;
        que.add(new Pos(i,j));
        
        while(!que.isEmpty()){
            int size = que.size();
            while(--size>=0){
                Pos pos = que.poll();
                for(int d=0;d<4;d++){
                    int dx = pos.x + dir[d][0];
                    int dy = pos.y + dir[d][1];

                    if(!(0<=dx && dx<h && 0<= dy && dy < w)) continue;
                    if(oilLand[dx][dy]==1 && !visited[dx][dy]){
                        visited[dx][dy]=true;
                        que.add(new Pos(dx,dy));
                        set.add(dy);
                        oilSize++;
                    }
                }   
            }
        }
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int next = it.next();
            oil[next]+=oilSize;
            if(oil[next]>maxOil) maxOil = oil[next];
        }

    }
    
    public int solution(int[][] land) {
        oilLand = land;
        h = land.length;
        w = land[0].length;
        visited = new boolean[h][w];
        oil = new int[w];
        
        for(int j=0;j<w;j++){
            for(int i=0;i<h;i++){
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        
        return maxOil;
    }
}