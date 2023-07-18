import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int totalPick = picks[0]+picks[1]+picks[2];
        
        int answer = 0;
        
        int setCnt = minerals.length/5+1;
        int[][]eng = new int[setCnt][3];
        
        for(int i=0;i<minerals.length && i < totalPick*5;i++){
            int level = i/5;
            if(minerals[i].equals("diamond")){
                eng[level][0]++;
                eng[level][1]+=5;
                eng[level][2]+=25;
            }else if(minerals[i].equals("iron")){
                eng[level][0]++;
                eng[level][1]++;
                eng[level][2]+=5;
            }else{
                eng[level][0]++;
                eng[level][1]++;
                eng[level][2]++;
            }
        }
        
        Arrays.sort(eng,(a,b)->{
            if(a[2]!=b[2]){
                return b[2]-a[2];
            }else if(a[1]!=b[1]){
                return b[1]-a[1];
            }else{
                return b[0]-a[0];
            }
        });    
        
        for(int i=0;i<setCnt; i++){
            if(picks[0]==0 && picks[1]==0 && picks[2]==0) break;
            
            if(picks[0]!=0){
                answer+=eng[i][0];
                picks[0]--;
            }else if(picks[1]!=0){
                answer+=eng[i][1];
                picks[1]--;
            }else{
                answer+=eng[i][2];
                picks[2]--;                
            }
        }
        
        
        return answer;
    }
}