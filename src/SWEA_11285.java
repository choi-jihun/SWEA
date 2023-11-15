import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_11285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                sum += check(x, y);
            }
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static int check(int x, int y) {
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        for (int p = 10; p >= 1; p--) {
            if (distance <= 20 * (11 - p)) {
                return p;
            }
        }
        return 0;
    }
}
