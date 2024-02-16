import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_작업순서 {

    static List<List<Integer>> graph;
    static int[] depth;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int test = 1; test <= 10; test++) {
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            depth = new int[V + 1];
            isVisited = new boolean[V + 1];
            sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph.get(start).add(end);
                depth[end]++;
            }

            sb.append("#").append(test);
            for (int i = 1; i < V + 1; i++) {
                if (depth[i] == 0 && !isVisited[i]) {
                    bfs(i);
                }
            }

            sb.append("\n");
            bw.write(sb + "");
            bw.flush();
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;
        sb.append(" ").append(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int node : graph.get(current)) {
                depth[node]--;
                if (depth[node] == 0) {
                    queue.offer(node);
                    isVisited[node] = true;
                    sb.append(" ").append(node);
                }
            }
        }
    }

}
