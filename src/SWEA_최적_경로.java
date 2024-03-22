import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_최적_경로 {

    static int N;
    static double ans;
    static int[][] arr;
    static boolean[] visited;
    static int startx, starty;
    static int endx, endy;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            visited = new boolean[N];
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            startx = Integer.parseInt(st.nextToken());
            starty = Integer.parseInt(st.nextToken());
            endx = Integer.parseInt(st.nextToken());
            endy = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            back(0, 0, startx, starty);
            bw.write(String.format("#%d %d\n", tc, min));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void back(int depth, int dis, int cx, int cy) {
        if (min < dis) {
            return;
        }

        if (depth == N) {
            dis += Math.abs(endx - cx) + Math.abs(endy - cy);
            min = Math.min(min, dis);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(depth + 1, dis + Math.abs(cx - arr[i][0]) + Math.abs(cy - arr[i][1]), arr[i][0], arr[i][1]);
                visited[i] = false;
            }
        }

    }
}
