class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int q=0;q<queries.length;q++){
            for(int s=queries[q][0]; s<=queries[q][1]; s++){
                arr[s]++;
            }
        }
        return arr;
    }
}