import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Contact {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static int maxDepth;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int test = 1; test <= 10; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            isVisited = new boolean[101];
            depth = new int[101];
            graph = new ArrayList<>();

            for (int i = 0; i < 101; i++) {
                graph.add(new ArrayList<Integer>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
            }

            bfs(start);
            int max = 0;
            for (int i = 0; i < 101; i++) {
                if (isVisited[i] && maxDepth == depth[i]) {
                    max = Math.max(max, i);
                }
            }
            bw.write("#" + test + " " + max + "\n");
            bw.flush();
        }

    }

    static void bfs(int start) {
        isVisited[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        maxDepth = 0;

        while (!que.isEmpty()) {
            int node = que.poll();
            for (int next : graph.get(node)) {
                if (!isVisited[next]) {
                    que.offer(next);
                    isVisited[next] = true;
                    depth[next] = depth[node] + 1;
                    maxDepth = Math.max(maxDepth, depth[next]);
                }
            }
        }
    }

}
