import java.util.*;

class Solution {
    public int solution(String s) {
        
        HashMap<String, String> number  = new HashMap<>();
        number.put("zero", "0");
        number.put("one", "1");
        number.put("two", "2");
        number.put("three", "3");
        number.put("four", "4");
        number.put("five", "5");
        number.put("six", "6");
        number.put("seven", "7");
        number.put("eight", "8");
        number.put("nine", "9");
        
        String answer = "";
        char[] sArr = s.toCharArray();
        
        String temp = "";
        for(int i=0;i<sArr.length;i++){
            if(number.get(temp)!=null){
                answer += number.get(temp);
                temp="";
            }
            if('0'<=sArr[i] && sArr[i] <='9'){
                answer += ""+sArr[i];
            }else{
                temp+=sArr[i];
            }
        }
        if(!temp.equals("")){
            answer += number.get(temp);
        }
        return Integer.parseInt(answer);
    }
}