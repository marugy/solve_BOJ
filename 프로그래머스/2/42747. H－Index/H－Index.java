import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int h=0;
        for(int i=0; i<citations.length; i++){
            while(h<=citations[i]){
                if(h<= citations[i] && h<=citations.length -i && i+1<=h){
                    answer=h;
                }
                h++;
            }
        }
        
        return answer;
    }
}