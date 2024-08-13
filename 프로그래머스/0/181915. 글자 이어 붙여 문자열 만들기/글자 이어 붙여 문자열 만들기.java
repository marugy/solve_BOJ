class Solution {
    public String solution(String my_string, int[] index_list) {
        String str = "";
        String[] arr = my_string.split("");
        for(int i=0;i<index_list.length; i++){
            str+=arr[index_list[i]];
        }
        return str;
    }
}