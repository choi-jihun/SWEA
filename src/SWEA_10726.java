import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String binary = Integer.toBinaryString(M);
            boolean flag = true;
            if (binary.length() < N) {
                sb.append("#").append(i).append(" OFF\n");
                continue;
            }
            for (int j = 1; j <= N; j++) {
                if (binary.charAt(binary.length() - j) == '0') {
                    sb.append("#").append(i).append(" OFF\n");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("#").append(i).append(" ON\n");
            }
        }
        System.out.println(sb);
    }
}
