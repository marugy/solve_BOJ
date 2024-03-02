class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static boolean[] used;
    
    static void dfs(String word, String target, String[]words, int cnt){
        
        if(word.equals(target)){
            if(answer > cnt) answer = cnt;
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(used[i] || !canChange(word, words[i])) continue;
            used[i]=true;
            dfs(words[i], target, words, cnt+1);
            used[i]=false;
        }
    }
    
    static boolean canChange(String A, String B){
        int dif = 0;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)!=B.charAt(i)) dif++;
        }
        if(dif==1){
            return true;
        }
        return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        used = new boolean[words.length];
        dfs(begin, target, words, 0);
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
}