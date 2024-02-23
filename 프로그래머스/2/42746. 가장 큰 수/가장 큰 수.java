import java.util.*;
class Solution {

    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length; i++)
            arr[i] = Integer.toString(numbers[i]);
        Arrays.sort(arr,(a,b)->{
            int lenA = a.length();
            int lenB = b.length();
            if(lenA == lenB) return b.compareTo(a);
            else if((a+b).compareTo(b+a)>0) return -1;
            else return 1;
        });
        for(int i=0;i<numbers.length; i++)
            answer+=arr[i];
        if(answer.charAt(0)=='0') return"0";
        return answer;
    }
}