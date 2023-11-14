import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            int max = arr[arr.length - 1];
            long sum = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                if (max >= arr[j]) {
                    sum += max - arr[j];
                } else {
                    max = arr[j];
                }
            }
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
