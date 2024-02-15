import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_길찾기 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int test = 1; test <= 10; test++) {
            graph = new ArrayList<>();
            isVisited = new boolean[100];
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 100; i++) {
                graph.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int start = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                graph.get(start).add(dest);
            }
            dfs(0);
            if (isVisited[99] == true) {
                bw.write("#" + test + " 1\n");
            } else {
                bw.write("#" + test + " 0\n");
            }
            bw.flush();
        }
    }

    static void dfs(int start) {
        isVisited[start] = true;

        for (int node : graph.get(start)) {
            if (!isVisited[node]) {
                dfs(node);
            }
        }
    }

}
