class Solution {
    public long solution(long n) {
        double answer = (double)Math.sqrt(n);
        if(answer%1 == 0)   return (long) (answer+1)*(long)(answer+1);
        else return -1;
    }
}