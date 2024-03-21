import java.io.*;
import java.util.*;

public class SWEA_하나로 {

    static class Island {
        int x, y;

        Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Island[] islands = new Island[N];
            double[][] cost = new double[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                islands[i] = new Island(x, 0);
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                islands[i].y = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cost[i][j] = calculateCost(islands[i], islands[j], E);
                }
            }

            double result = prim(cost, N);

            System.out.printf("#%d %d\n", tc, Math.round(result));
        }
    }

    static double calculateCost(Island a, Island b, double E) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return E * (dx * dx + dy * dy);
    }

    static double prim(double[][] graph, int N) {
        double[] key = new double[N];
        boolean[] included = new boolean[N];
        Arrays.fill(key, Double.MAX_VALUE);
        key[0] = 0;

        double totalCost = 0;

        for (int count = 0; count < N; count++) {
            double min = Double.MAX_VALUE;
            int u = -1;

            for (int i = 0; i < N; i++) {
                if (!included[i] && key[i] < min) {
                    min = key[i];
                    u = i;
                }
            }

            included[u] = true;
            totalCost += min;

            for (int v = 0; v < N; v++) {
                if (!included[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        return totalCost;
    }
}
