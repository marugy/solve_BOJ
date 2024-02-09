class Solution {
    public int solution(int n) {
        int next = n+1;
        String nStrNum = Integer.toBinaryString(n).replace("0", "");
        while(true){
            String nextStrNum = Integer.toBinaryString(next).replace("0","");
            if(nStrNum.length() == nextStrNum.length()){
                return next;
            }
            next++;
        }
    }
}