import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int max = -1;
            int min = Integer.MAX_VALUE;
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                max = Math.max(max, cal(temp));
                min = Math.min(min, cal(temp));
            }

            sb.append("#").append(tc).append(" ").append(max).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static int cal(String str) {
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            temp += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return temp;
    }
}
