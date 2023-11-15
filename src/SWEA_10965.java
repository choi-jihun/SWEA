import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SWEA_10965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int A = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 2; j <= Math.sqrt(A); j++) {
                while (A % j == 0) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    A /= j;
                }
            }

            if (A > 1) {
                map.put(A, 1);
            }

            int ans = 1;
            for (int prime : map.keySet()) {
                int temp = map.get(prime);
                if (temp % 2 != 0)
                    ans *= prime;
            }
            sb.append("#").append(i).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
