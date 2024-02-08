class Solution {
    public int[] solution(int brown, int yellow) {
        //가로 x, 세로 y, 전체 x*y
        //갈색 2x+2*(y-2) = 2x + 2y -4 = brown
        //노란색 xy - 2x -2y + 4 = yellow
        int x = 1;
        while(true){
            int y = (brown - 2*x +4)/2;
            if(x*y-2*x-2*y+4==yellow){
                return new int[]{y,x};
            }
            x++;
        }
    }
}