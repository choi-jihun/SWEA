import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_12004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (check(N)){
                sb.append("#").append(i).append(" Yes\n");
            } else {
                sb.append("#").append(i).append(" No\n");
            }
        }
        System.out.println(sb);
    }

    static boolean check(int temp) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++)
                if (i * j == temp)
                    return true;
        }
        return false;
    }
}
