import java.util.*;

class Solution {
    static int n, m;
    static boolean[][]visited;
    static String[][]map;
    int [][]dir = {{-1,0},{1,0}, {0,-1}, {0,1}};
    int day = 0;
    
    public void travle(int x, int y){
        
        for(int d=0; d<4; d++){
            int xx = x + dir[d][0];
            int yy = y + dir[d][1];
            
            if(!(0<=xx && xx < n && 0<= yy && yy < m)) continue;
            
            if(!visited[xx][yy] && !map[xx][yy].equals("X")){
                visited[xx][yy]= true;
                day+=Integer.parseInt(map[xx][yy]);
                travle(xx,yy);
            }
        }
        
        
        
    }
    
    
    public int[] solution(String[] maps) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        n = maps.length;
        m = maps[0].split("").length;
        
        map = new String[n][m];
        visited = new boolean[n][m];
        
        for(int i=0;i<n; i++){
            String[] tmp = maps[i].split("");
            for(int j=0;j<m; j++){
                map[i][j] = tmp[j];
            }
        }
        for(int i=0;i<n; i++){
            for(int j=0;j<m; j++){
                if(!visited[i][j] && !map[i][j].equals("X")){
                    day = Integer.parseInt(map[i][j]);
                    visited[i][j]=true;
                    travle(i,j);
                    if(day!=0){
                        arr.add(day);
                        day=0;
                    }
                }
            }
        }
        

        if(arr.size()==0){
            int[]answer = {-1};
            return answer;
        }else{
            int []answer = new int[arr.size()];
            arr.sort((a,b)->{return a-b;});
            for(int i=0;i<arr.size();i++){
                answer[i]=arr.get(i);
            }

            return answer;
        }

    }
}