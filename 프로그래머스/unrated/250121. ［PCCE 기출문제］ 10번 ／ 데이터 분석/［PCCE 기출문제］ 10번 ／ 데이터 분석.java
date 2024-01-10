import java.util.*;

class Solution {
    //코드번호, 제조일, 최대 수량, 현재수량
    //ext 어떤 기준
    //val_ext 기준 값
    //sort_by 정렬 기준
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        
        int[][]answer = new int[data.length][4];
        int number = 0;
        
        for(int i=0;i<data.length;i++){
            if(data[i][map.get(ext)]<val_ext){
                answer[number]=data[i];
                number++;
            }
        }      
        
        int[][]sortedArray = new int[number][4];
        for(int i=0;i<number;i++){
            sortedArray[i] = answer[i];
        }

        Arrays.sort(sortedArray, (a,b)->{
            return a[map.get(sort_by)] - b[map.get(sort_by)];
        });
        
        return sortedArray;
        
    }
}