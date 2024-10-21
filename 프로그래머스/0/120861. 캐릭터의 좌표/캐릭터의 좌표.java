
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[]answer = {0,0};
        int maxH = board[0]/2;
        int maxW = board[1]/2;
        for(String str : keyinput){
            if(str.equals("left")){
                if(-1*maxH<answer[0])
                    answer[0]--;
            }else if(str.equals("right")){
                if(answer[0]< maxH)
                    answer[0]++;
            }else if(str.equals("up")){
                if(answer[1]<maxW)
                    answer[1]++;
            }else if(str.equals("down")){
                if(-1*maxW<answer[1])
                    answer[1]--;
            }
        }
        return answer;
    }
}