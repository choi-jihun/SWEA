import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_17642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            Long A = Long.parseLong(st.nextToken());
            Long B = Long.parseLong(st.nextToken());

            long diff = B - A;
            if (diff == 0) {
                sb.append("#").append(idx).append(" ").append(0).append("\n");
            } else if (A > B || diff == 1) {
                sb.append("#").append(idx).append(" ").append(-1).append("\n");
            } else {
                if (diff % 2 == 1) {
                    sb.append("#").append(idx).append(" ").append((diff - 1) / 2).append("\n");
                } else {
                    sb.append("#").append(idx).append(" ").append(diff / 2).append("\n");
                }
            }
            idx++;
        }
        System.out.println(sb);
    }
}
