import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_7102 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb = new StringBuilder();
            int[] arr = new int[N + M + 1];
            int max = -1;
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    arr[i + j]++;
                    max = Math.max(max, arr[i + j]);
                }
            }

            for (int i = 0; i < N + M + 1; i++) {
                if (arr[i] == max) {
                    sb.append(i + " ");
                }
            }

            bw.write(String.format("#%d %s\n", tc, sb));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
