class Solution {
    public int solution(String myString, String pat) {
        String[] arr = myString.split("");
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("A"))
                arr[i]="B";
            else{
                arr[i]="A";
            }
        }

        String answer = String.join("",arr);
        if(answer.contains(pat))
            return 1;
        return 0;
    }
}