import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9611 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[10];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                String str = st.nextToken();

                if (str.equals("YES")) {
                    if (arr[a] != -1) {
                        arr[a]++;
                    }
                    if (arr[b] != -1) {
                        arr[b]++;
                    }
                    if (arr[c] != -1) {
                        arr[c]++;
                    }
                    if (arr[d] != -1) {
                        arr[d]++;
                    }
                } else {
                    arr[a] = -1;
                    arr[b] = -1;
                    arr[c] = -1;
                    arr[d] = -1;
                }
            }
            int max = -1;
            int ans = 0;
            for (int j = 0; j < 10; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    ans = j;
                }
            }
            sb.append("#").append(i).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
