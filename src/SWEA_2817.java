import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            int ans = dfs(0, 0);
            sb.append("#").append(i).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int idx, int sum) {
        if (sum == K) {
            return 1;
        }
        if (sum > K) {
            return 0;
        }

        int cnt = 0;
        for (int i = idx; i < N; i++) {
            cnt += dfs(i + 1, sum + arr[i]);
        }
        return cnt;
    }
}
