import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_동철이의_일_분배 {

    static int N;
    static double ans;
    static double[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new double[N][N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
                }
            }

            ans = 0.0;
            back(0, 1.0);
            bw.write(String.format("#%d %.6f\n", tc, ans * 100));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void back(int cnt, double temp) {
        if (temp <= ans)
            return;

        if (cnt == N) {
            ans = Math.max(ans, temp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(cnt + 1, arr[cnt][i] * temp);
                visited[i] = false;
            }
        }
    }
}
