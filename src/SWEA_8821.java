import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SWEA_8821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                int key = Integer.parseInt(String.valueOf(str.charAt(i)));
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int cnt = 0;
            for (int val : map.keySet()) {
                int temp = map.get(val);
                if (temp % 2 == 1) {
                    cnt++;
                }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
