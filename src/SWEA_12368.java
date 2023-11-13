import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A + B == 24) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
            } else if (A + B > 24) {
                sb.append("#").append(i).append(" ").append(A + B - 24).append("\n");
            } else {
                sb.append("#").append(i).append(" ").append(A + B).append("\n");
            }
        }
        System.out.println(sb);
    }
}
