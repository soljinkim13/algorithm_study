import java.util.*;
import java.io.*;

public class Solution {
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		long cost;
		
		Edge(int from, int to, long cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
        		
	}
	
	public static int find(int x){
		if (parent[x]==x) return x;
		
		return parent[x] = find(parent[x]);
	}
	static boolean union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB) return false;
		parent[rootB] = rootA;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

            long[] x = new long[N];
            long[] y = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                y[i] = Long.parseLong(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());
			
			int edgeCount = N * (N - 1) / 2;
            Edge[] edges = new Edge[edgeCount];
            			
            int idx = 0;
			for(int i = 0; i<N;i++){
				for(int j = i+1; j<N; j++){
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					
					long dist = dx*dx +dy*dy;
					edges[idx++] = new Edge(i, j, dist);
				}
			}
			
			Arrays.sort(edges);
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            long total = 0;
            int count = 0;

            for (Edge edge : edges) {
                if (union(edge.from, edge.to)) {
                    total += edge.cost;
                    count++;

                    if (count == N - 1) break;
                }
            }
            long answer = Math.round(total * E);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
	}
}