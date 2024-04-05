class Solution {
    public String solution(String s) {
        int l = s.length()/2;
        if(s.length()%2==0){
            return s.split("")[l-1]+s.split("")[l];
        }
        return s.split("")[l];
    }
}