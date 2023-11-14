import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if ((arr[j][0] < arr[k][0] && arr[j][1] > arr[k][1]) ||
                            (arr[j][0] > arr[k][0] && arr[j][1] < arr[k][1])) {
                        cnt++;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");

        }

        System.out.println(sb);
    }
}
