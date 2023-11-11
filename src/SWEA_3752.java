import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3752 {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            boolean []dp = new boolean[10001];
            dp[0] = true;
            int total = 0;
            for (int score : arr) {
                total += score;
                for (int k = total; k >= score; k--) {
                    dp[k] |= dp[k - score];
                }
            }

            int count = 0;
            for (boolean value : dp) {
                if (value) count++;
            }

            sb.append("#").append(i).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
