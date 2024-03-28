class Solution {
    boolean solution(String s) {

        int p = 0, y = 0;
        String[] str = s.split("");
        for(int i=0;i<str.length; i++){
            if(str[i].equals("p") || str[i].equals("P")) p++;
            else if(str[i].equals("y") || str[i].equals("Y")) y++;
        }
        if(p==y) return true;
        return false;
    }
}