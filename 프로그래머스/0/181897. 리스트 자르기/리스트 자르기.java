import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch(n){
            case 1:
                return Arrays.copyOfRange(num_list, 0, slicer[1]+1);
            case 2:
                return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
            case 3:
                return Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
            default:
                int[] answer ;
                
                if((slicer[1]-slicer[0]+1)%slicer[2]==0)
                    answer = new int[(slicer[1]-slicer[0]+1)/slicer[2]];
                else answer = new int[(slicer[1]-slicer[0]+1)/slicer[2]+1];
                for(int i=0; i<answer.length; i++)
                    answer[i]= num_list[ slicer[0] + i*slicer[2] ];
                return answer;
        }
    }
}