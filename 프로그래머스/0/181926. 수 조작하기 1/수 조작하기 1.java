class Solution {
    public int solution(int n, String control) {
        String[] temp = control.split("");
        for(int i=0;i<temp.length; i++){
            if(temp[i].equals("w")) n++;
            else if(temp[i].equals("s")) n--;
            else if(temp[i].equals("d")) n+=10;
            else n-=10;
        }
        return n;
    }
}