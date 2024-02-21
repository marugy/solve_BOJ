class Solution {
    public int solution(int[][] sizes) {
        int minW = 0;
        int minH = 0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp  = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if(minW<sizes[i][0]) minW = sizes[i][0];
            if(minH<sizes[i][1]) minH = sizes[i][1];
        }
        return minW*minH;
    }
}