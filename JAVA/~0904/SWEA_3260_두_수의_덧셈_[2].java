import java.util.Scanner;

public class SWEA_3260 {
    static String A;
    static String B;
    static StringBuilder answer;
    static int maxSize;

    public static void add(int position, int ten) {
        if (position == maxSize) {
            if (ten > 0) {
                answer.append(ten);
            }
            return;
        }
        int numA = 0;
        int numB = 0;
        int indexA = A.length()-1-position;
        int indexB = B.length()-1-position;

        if (indexA >= 0) numA = A.charAt(indexA) - '0';
        if (indexB >= 0) numB = B.charAt(indexB) - '0';
        int sum = numA + numB + ten;
        answer.append(sum % 10);
        add(position + 1, sum / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            A = sc.next();
            B = sc.next();
            answer = new StringBuilder();
            maxSize = Math.max(A.length(), B.length());

            add(0, 0);

            answer.reverse();
  
            
            System.out.println("#" + tc + " " + answer);
        }

        
    }
}