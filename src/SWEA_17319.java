import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_17319 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int idx = 1;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            if (N % 2 == 1) {
                sb.append("#").append(idx).append(" ").append("No").append("\n");
            } else {
                String sub1 = str.substring(0, (N / 2));
                String sub2 = str.substring((N / 2), N);
                if (sub1.equals(sub2)) {
                    sb.append("#").append(idx).append(" ").append("Yes").append("\n");
                } else {
                    sb.append("#").append(idx).append(" ").append("No").append("\n");
                }
            }
            idx++;
        }
        System.out.println(sb);
    }
}
