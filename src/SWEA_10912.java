import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SWEA_10912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            List<Character> oddChars = new ArrayList<>();
            for (char ch : map.keySet()) {
                if (map.get(ch) % 2 != 0) {
                    oddChars.add(ch);
                }
            }

            Collections.sort(oddChars);

            sb.append("#").append(i).append(" ");
            if (oddChars.isEmpty()) {
                sb.append("Good");
            } else {
                for (char ch : oddChars) {
                    sb.append(ch);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
