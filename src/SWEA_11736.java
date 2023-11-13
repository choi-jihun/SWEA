import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_11736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int j = 1; j < N - 1; j++) {
                if (arr[j] != Math.max(arr[j + 1], Math.max(arr[j], arr[j - 1]))
                        && arr[j] != Math.min(arr[j + 1], Math.min(arr[j], arr[j - 1]))) {
                    cnt++;
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
