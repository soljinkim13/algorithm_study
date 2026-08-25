class Solution {
    public static int answer;
    
    public static void cal(int[] numbers, int depth, int total, int target){
        if(depth == numbers.length) {
            if(total == target) answer++;
            return;
        }
            
        cal(numbers,depth+1, total-numbers[depth],target);
        cal(numbers,depth+1, total+numbers[depth],target);
    }
    
    public int solution(int[] numbers, int target) {

        cal(numbers, 0, 0,target);
        return answer;
    }
}