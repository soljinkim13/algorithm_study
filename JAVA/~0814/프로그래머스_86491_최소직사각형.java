class Solution {
    public int solution(int[][] sizes) {
    	int rowMax = 0;
    	int colMax = 0;
        for(int i = 0;i<sizes.length;i++){
        	int row = sizes[i][0];
        	int col = sizes[i][1];
         	if(sizes[i][0]<sizes[i][1]) {
         		row = sizes[i][1];
            	col = sizes[i][0];
        	}
            rowMax = rowMax>row?rowMax:row;
            colMax = colMax>col?colMax:col;
        }
        int answer = rowMax*colMax;
        return answer;
    }
}