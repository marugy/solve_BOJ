class Solution {
    public int solution(int num, int k) {
        String[] str = (""+num).split("");
        for(int i=0;i<str.length;i++){
            if(Integer.parseInt(str[i])==k) return i+1;
        }
        return -1;
    }
}