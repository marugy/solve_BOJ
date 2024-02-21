class Solution {
    
    public int maxCnt(int a, int b, int c){
        if(a==b && b==c) return 3;
        else if((a==b && a>c)||(a==c && a>b)||(c==b && a<c)) return 2;
        else return 1;
    }
    
    public int[] solution(int[] answers) {
        int []a = {1,2,3,4,5};
        int []b = {2,1,2,3,2,4,2,5};
        int []c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int an=0, bn=0, cn=0, aa=0, bb=0 ,cc =0;
        
        for(int i=0; i< answers.length; i++){
            if(answers[i]==a[an]) aa++;
            if(answers[i]==b[bn]) bb++;
            if(answers[i]==c[cn]) cc++;
            an= (an+1)%5;
            bn= (bn+1)%8;        
            cn= (cn+1)%10;            
        }
        int cnt = maxCnt(aa,bb,cc);
        if(cnt==1){
            if(aa>bb && aa>cc) return new int[]{1};
                else if((bb>aa && bb>cc)) return new int[]{2};
                else return new int[]{3};}
        else if(cnt==2){
            if(aa==bb) return new int[]{1,2};
            else if(bb==cc) return new int[]{2,3};
            else return new int[]{1,3};
        }else{
            return new int[]{1,2,3};
        }
    }
}