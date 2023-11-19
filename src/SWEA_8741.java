import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            sb.append("#").append(tc).append(" ");
            while (st.hasMoreTokens()) {
                String str = st.nextToken().toUpperCase();
                sb.append(str.charAt(0));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
