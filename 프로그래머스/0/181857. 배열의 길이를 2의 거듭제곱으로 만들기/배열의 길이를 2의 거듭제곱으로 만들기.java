class Solution {
    public int[] solution(int[] arr) {
        int length = 1;
        while(arr.length>length){
            length*=2;
        }
        int[] answer = new int[length];
        for(int i=0;i<arr.length;i++){
            answer[i]=arr[i];
        }
        return answer;
    }
}