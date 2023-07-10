import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map <String, Integer> playerInfo = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            playerInfo.put(players[i], i);
        }
        for(int i=0; i<callings.length; i++){
            
            String temp = players[playerInfo.get(callings[i])-1];//앞선 순위
            players[playerInfo.get(callings[i])-1] = players[playerInfo.get(callings[i])];
            players[playerInfo.get(callings[i])] = temp;
            
            playerInfo.put(callings[i],playerInfo.get(callings[i])-1);
            playerInfo.put(temp,playerInfo.get(temp)+1);
        }
        
        return players;
    }
}