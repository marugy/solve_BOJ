class Solution {
    
    static String[] str = {"A","E","I","O","U"};
    static int answer = 0;   
    static int count = 0;
    
    static void findCount(String target, String word){
        

        if(target.equals(word)){
            answer = count;
            return;
        }

        if(word.length()>=5) return;
        
        for(int i=0; i<5; i++){
            count++;
            findCount(target, word+str[i]);
        }
    }
    
    public int solution(String word) {

        findCount(word, "");
        
        return answer;
    }
}