class Solution {
    public String solution(String str1, String str2) {
        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");
        String[] ansArr = new String[arr1.length + arr2.length];
        for(int i=0;i<arr1.length; i++){
            ansArr[i*2] = arr1[i];
            ansArr[i*2+1]=arr2[i];
        }
        return String.join("",ansArr);
    }
}