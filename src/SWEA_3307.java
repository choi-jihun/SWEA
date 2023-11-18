import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N];
            Arrays.fill(dp, 1);
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < j; k++) {
                    if (arr[k] < arr[j]) {
                        dp[j] = Math.max(dp[j], dp[k] + 1);
                    }
                }
            }

            int max = 0;
            for (int j = 0; j < N; j++)
                max = Math.max(dp[j], max);
            sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
