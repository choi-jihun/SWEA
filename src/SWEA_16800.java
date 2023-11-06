import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_16800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            long N = Long.parseLong(br.readLine());
            long min = Long.MAX_VALUE;
            double sqrt = Math.sqrt(N);
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j <= sqrt; j++) {
                if (N % j == 0) {
                    min = Math.min(min, j + (N / j)) - 2;
                }
            }
            sb.append("#").append(i).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
}
