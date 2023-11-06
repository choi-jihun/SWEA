import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_15941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(i).append(" ").append((int) Math.pow(N, 2)).append("\n");
        }
        System.out.println(sb);
    }
}
