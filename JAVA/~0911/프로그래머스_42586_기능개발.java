import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int num = 0;
        ArrayList<Integer> check = new ArrayList<>();
        int count = 0;
        
        while(num<progresses.length){
            for(int i  = 0 ; i<progresses.length ; i++){
                progresses[i] += speeds[i];
            }
            
            for(int i = num ; i<progresses.length ; i++){
                if(progresses[i] < 100){
                    break;
                }else count++;
            }
            num+=count;
            if(count!=0) check.add(count);
            count = 0;
        }
        
        return check;
    }
}