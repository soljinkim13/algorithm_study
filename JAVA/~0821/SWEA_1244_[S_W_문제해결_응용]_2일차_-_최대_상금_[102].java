import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA_1244 {
	  static int M;
	    static int max;

	    static Set<String>[] visited;

	    static void dfs(char[] arr, int count) {

	        String current = new String(arr);

	        if (visited[count].contains(current)) {
	            return;
	        }

	        visited[count].add(current);

	        if (count == M) {
	            int num = Integer.parseInt(current);
	            max = Math.max(max, num);
	            return;
	        }

	        for (int i = 0; i < arr.length - 1; i++) {
	            for (int j = i + 1; j < arr.length; j++) {

	                swap(arr, i, j);
	                dfs(arr, count + 1);
	                swap(arr, i, j);
	            }
	        }
	    }

	    static void swap(char[] arr, int i, int j) {

	        char temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int T = sc.nextInt();

	        for (int tc = 1; tc <= T; tc++) {

	            String number = sc.next();
	            M = sc.nextInt();

	            max = 0;

	            visited = new HashSet[M + 1];

	            for (int i = 0; i <= M; i++) {
	                visited[i] = new HashSet<>();
	            }

	            dfs(number.toCharArray(), 0);

	            System.out.println("#" + tc + " " + max);
	        }
	    }
	}
