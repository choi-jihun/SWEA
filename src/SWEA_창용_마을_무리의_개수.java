import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_창용_마을_무리의_개수 {

    static int N, M;
    static int cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            cnt = 0;
            visited = new boolean[N + 1];
            graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    bfs(i);
                    cnt++;
                }
            }

            bw.write(String.format("#%d %d\n", tc, cnt));

        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
