import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_14555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int cnt = 0;
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '(') {
                    cnt++;
                    if (ch[j + 1] == ')') {
                        j++;
                    }
                } else if (ch[j] == ')') {
                    cnt++;
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
