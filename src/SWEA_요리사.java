import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_요리사 {

    static int N;
    static int[][] arr;
    static boolean[] selected;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            selected = new boolean[N];
            ans = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combine(0, 0);
            bw.write(String.format("#%d %d\n", tc, ans));
        }
        bw.flush();
    }

    static void combine(int start, int depth) {
        if (depth == N / 2) {
            int diff = calculate();
            ans = Math.min(ans, diff);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                combine(i + 1, depth + 1);
                selected[i] = false;
            }
        }
    }

    static int calculate() {
        int a = 0;
        int b = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    a += arr[i][j] + arr[j][i];
                } else if (!selected[i] && !selected[j]) {
                    b += arr[i][j] + arr[j][i];
                }
            }
        }

        return Math.abs(a - b);
    }
}