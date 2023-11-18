import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][L + 1];

            for (int j = 1; j <= N; j++) {
                for (int k = 0; k <= L; k++) {
                    //현재 고려 중인 칼로리 arr[j - 1][1]
                    if (arr[j - 1][1] <= k) {
                        //재료 추가 전 최대 맛(dp[j - 1][k])와
                        //k - arr[j - 1][1] 현재 칼로리 한도 k에서 현재 재료 칼로리 뺀 값
                        //이전 맛 최대값(dp[j - 1][k - arr[j - 1][1]]) + 현재 맛 점수 (arr[j - 1][0])
                        dp[j][k] = Math.max(dp[j - 1][k], dp[j - 1][k - arr[j - 1][1]] + arr[j - 1][0]);
                    } else {
                        dp[j][k] = dp[j - 1][k];
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(dp[N][L]).append("\n");
        }
        System.out.println(sb);
    }
}
