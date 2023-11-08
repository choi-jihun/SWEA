import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_14692 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N % 2 == 0) {
                sb.append("#").append(i).append(" Alice\n");
            } else
                sb.append("#").append(i).append(" Bob\n");
        }
        System.out.println(sb);
    }
}
