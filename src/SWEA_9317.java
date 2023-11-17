import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            br.readLine();
            String str1 = br.readLine();
            String str2 = br.readLine();

            int cnt = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == str2.charAt(j))
                    cnt++;
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
