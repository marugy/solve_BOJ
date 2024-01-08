class Solution {
    
    //bandage : 기술 시간, 회복량, 추가 회복량
    //health : 최대체력
    //attakcs : 몬스터 공격 시간과 피해량
    public int solution(int[] bandage, int health, int[][] attacks) {

        int hp = health;
        int time = 0;
        for(int i=0;i<attacks.length; i++){
            hp +=  (attacks[i][0]-time -1)*bandage[1];
            hp += (attacks[i][0]-time -1)/bandage[0]*bandage[2];
            if(hp>health) hp = health;
            hp-=attacks[i][1];
            if(hp<=0){
                return -1;
            }
            time = attacks[i][0];
        }
        return hp;
    }
}