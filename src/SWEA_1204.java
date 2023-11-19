import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        for (int i = 1; i <= T; i++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();

            while (st.hasMoreTokens()) {
                int score = Integer.parseInt(st.nextToken());
                map.put(score, map.getOrDefault(score, 0) + 1);
            }

            int maxKey = 0;
            int maxValue = 0;
            for (int val : map.keySet()) {
                int fre = map.get(val);
                if (fre >= maxValue && maxKey < val) {
                    maxValue = fre;
                    maxKey = val;
                }
            }
            sb.append("#").append(i).append(" ").append(maxKey).append("\n");
        }
        System.out.println(sb);
    }
}
