import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        ArrayList list = new ArrayList<>();
        ArrayList answer = new ArrayList<>();
        
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(end<sequence.length){
            if(sum<k){
                list.add(sequence[end]);
                sum+=sequence[end++];
            }else if(sum>=k){
                sum-=sequence[start++];
                list.remove(0);
            }
            
            if(sum==k && (list.size() < answer.size() || answer.size()==0)){
                answer = new ArrayList<>(list);
            }
        }
        System.out.print(answer.toString());
        
        int[]tmp = new int[1];
        return tmp;
    }
}