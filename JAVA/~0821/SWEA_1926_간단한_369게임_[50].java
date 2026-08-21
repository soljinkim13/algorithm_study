	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);
            int clap = 0;

            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);
                if (ch=='3'||ch =='6'||ch =='9') {
                    clap++;
                }
            }

            if (clap> 0) {
                for (int j = 0; j < clap; j++) {
                    System.out.print("-");
                }
            } else {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}