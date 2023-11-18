import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            int cnt = 0;
            char last = '0';

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != last) {
                    cnt++;
                    last = str.charAt(j);
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
