import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SWEA_17937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());
            if (A.equals(B)) {
                sb.append("#").append(idx).append(" ").append(A).append("\n");
            } else {
                sb.append("#").append(idx).append(" ").append(1).append("\n");
            }
            idx++;
        }
        System.out.println(sb);
    }
}
