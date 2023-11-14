import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            double avg = (double) sum / N;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (avg >= arr[j]) {
                    cnt++;
                }
            }

            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
