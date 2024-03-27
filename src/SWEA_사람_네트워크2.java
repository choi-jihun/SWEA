import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_사람_네트워크2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distance[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && distance[i][j] == 0)
                        distance[i][j] = 10000000;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (distance[i][k] + distance[k][j] < distance[i][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }

            int minCC = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int cc = 0;
                for (int j = 0; j < N; j++) {
                    cc += distance[i][j];
                }
                minCC = Math.min(minCC, cc);
            }

            bw.write("#" + tc + " " + minCC + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
