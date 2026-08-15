import java.util.ArrayList;


class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        ArrayList<Integer> answerPerson = new ArrayList<>();
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        int[] firstNum = {1, 2, 3, 4, 5};
        int[] secondNum = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdNum = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstIdx;
        int secondIdx;
        int thirdIdx;
        
        for(int i = 0;i<answers.length;i++) {
        	firstIdx = i%firstNum.length;
        	secondIdx = i%secondNum.length;
        	thirdIdx = i%thirdNum.length;
        	if(answers[i]==firstNum[firstIdx]) answer[0]++;
        	if(answers[i]==secondNum[secondIdx]) answer[1]++;
        	if(answers[i]==thirdNum[thirdIdx]) answer[2]++;
        }
        
        int max = 0;
        for(int i =0;i<answer.length;i++) {
        	max = max>answer[i]?max:answer[i];
        }
        for(int i =0;i<answer.length;i++) {
        	if(max==answer[i]) answerPerson.add(i+1);
        }
        int size = answerPerson.size();
        int[] finalAnswer = new int[size];
        
        for(int i=0;i<size;i++) {
        	finalAnswer[i] = answerPerson.get(i);
        }

        
        return finalAnswer;
    }
}