import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][N + 1];
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[j], 1);
            }

            sb.append("#").append(i).append("\n");
            for (int j = 2; j < N; j++) {
                for (int k = 1; k < j; k++) {
                    dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < j + 1; k++) {
                    sb.append(dp[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
