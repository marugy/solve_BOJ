import java.util.*;

class Solution {
    
    static class Time{
        int startTime;
        int endTime;
        
        Time(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        ArrayList<Time> tArr = new ArrayList<>();
        
        int []tmp = new int[24*60+10];
        
        for(int i=0; i<book_time.length; i++){
            String[] start = book_time[i][0].split(":");
            int startTime = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            int endTime = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]) + 10;
            
            for(int j=startTime; j< endTime; j++){
                tmp[j]++;
            }
            
            Time t = new Time(startTime, endTime);
            tArr.add(t);
        }
        
        // tArr.sort((a,b) -> {
        //     return a.startTime - b.startTime;}
        // );
        
        // int startTime = tArr.get(0).startTime;
        // int endTime = tArr.get(0).endTime;
        // int roomCnt = 1;
        // for(int i=1;i<tArr.size();i++){
        //     if(tArr.get(i).startTime < endTime){
        //         roomCnt++;
        //     }
        // }
        // for(int i=0; i<tArr.size(); i++){
        //     for(int j=tArr.get(i).startTime; j< tArr.get(i).endTime; j++){
        //         tmp[j]++;
        //     }
        // }
        
        int max = 0;
        for(int i=0; i<tmp.length; i++){
            if(tmp[i] > max){
                max = tmp[i];
            }
        }
        
        return max;
    }
}