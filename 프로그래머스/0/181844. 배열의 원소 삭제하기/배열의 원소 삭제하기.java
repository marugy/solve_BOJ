import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : arr) list.add(val);
        for(Integer val: delete_list) list.remove(val);
        int []answer = new int[list.size()];
        for(int i=0;i<list.size(); i++)answer[i]=list.get(i); 
        return answer;
    }
}