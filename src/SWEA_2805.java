import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//쉽다고 생각했는데 헤맸다...
public class SWEA_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[][] ch = new char[N][N];

            for (int j = 0; j < N; j++) {
                ch[j] = br.readLine().toCharArray();
            }

            int sum = 0;
            for (int j = 0; j < N; j++) {
                int start = Math.abs(N / 2 - j);
                int end = N - start;

                for (int k = start; k < end; k++) {
                    sum += Integer.parseInt(String.valueOf(ch[j][k]));
                }
            }
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
