import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_7465 {

    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int value : graph.get(node)) {
            if (!visited[value]) {
                dfs(value);
            }
        }
    }
}
