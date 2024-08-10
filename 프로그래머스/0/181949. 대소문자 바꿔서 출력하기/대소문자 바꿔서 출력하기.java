import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[]arr = str.toCharArray();
        String answer ="";
        for(int i=0;i<arr.length; i++){
            if('a'<=arr[i] && arr[i]<='z'){
                answer += Character.toString(arr[i]-'a'+'A');
            }else{
                answer += Character.toString(arr[i]-'A'+'a');
            }
        }
        System.out.print(answer);
    }
}