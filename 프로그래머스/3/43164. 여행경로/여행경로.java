import java.util.*;

class Solution {
    
    static boolean []used;
    static boolean done;
    static String[] arr;
    
    static void dfs(String[][] tickets, int num, int cnt){
        
        if(cnt==tickets.length){
            done = true;
            arr[cnt]=tickets[num][1];
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(used[i] || !tickets[i][0].equals(tickets[num][1])) continue;
            used[i]=true;
            arr[cnt] = tickets[i][0];
            dfs(tickets, i,cnt+1);
            if(done) return;
            used[i]=false;
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        used = new boolean[tickets.length];
        arr = new String[tickets.length+1];
        arr[0]="ICN";
        
        Arrays.sort(tickets, (a,b)->{
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                used[i]=true;
                dfs(tickets, i, 1);
                if(done) return arr;
                used[i]=false;
            }
        }
        return arr;
    }
}