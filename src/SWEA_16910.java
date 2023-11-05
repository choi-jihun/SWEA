import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_16910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (T-- > 0) {
            int count = 0;
            int N = Integer.parseInt(br.readLine());
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (Math.pow(i, 2) + Math.pow(j, 2) <= Math.pow(N, 2)) {
                        count++;
                    }
                }
            }
            count += N;
            count *= 4;
            count += 1;
            sb.append("#").append(idx).append(" ").append(count).append("\n");
            idx++;
        }
        System.out.println(sb);
    }
}
