class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length < arr2.length) return -1;
        else if(arr1.length > arr2.length) return 1;
        else{
            int aSum = 0;
            int bSum = 0;
            for(int val : arr1) aSum+=val;
            for(int val : arr2) bSum+=val;
            if(aSum < bSum) return -1;
            else if(aSum > bSum) return 1;
            else return 0;
        }
    }
}