import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_11856 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            char[] ch = br.readLine().toCharArray();
            Arrays.sort(ch);
            if ((ch[1] == ch[2]) || (ch[0] != ch[1]) || (ch[2] != ch[3])) {
                sb.append("#").append(i).append(" No\n");
            } else {
                sb.append("#").append(i).append(" Yes\n");
            }
        }
        System.out.println(sb);
    }
}
