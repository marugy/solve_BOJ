class Solution {
    public int solution(String[][] board, int h, int w) {
        int [][]dir = {{-1,0}, {1,0}, {0,1}, {0, -1}};
        int same = 0;
        String pos = board[h][w];
        for(int i=0;i<4;i++){
            int dx = h + dir[i][0];
            int dy = w + dir[i][1];
            if(!(0<=dx && dx<board.length && 0<=dy && dy<board[0].length)) continue;
            if(pos.equals(board[dx][dy])) same++;
        }
        return same;
    }
}