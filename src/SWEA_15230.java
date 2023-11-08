import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_15230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char[] ch = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch[j]) {
                    cnt++;
                } else {
                    break;
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
