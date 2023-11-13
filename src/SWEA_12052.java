import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12052 {
    static int N, M;
    static char[][] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ch = new char[N][M];
            for (int j = 0; j < N; j++)
                ch[j] = br.readLine().toCharArray();
            boolean ans = true;

            outerLoop:
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (ch[j][k] == '#' && !check(j, k)) {
                        sb.append("#").append(i).append(" NO\n");
                        ans = false;
                        break outerLoop;
                    }
                }
            }
            if (ans) {
                sb.append("#").append(i).append(" YES\n");
            }
        }
        System.out.println(sb);
    }

    static boolean check(int x, int y) {
        if (x + 1 >= N || y + 1 >= M) {
            return false;
        }
        if (ch[x + 1][y] != '#' || ch[x][y + 1] != '#' || ch[x + 1][y + 1] != '#') {
            return false;
        } else {
            ch[x][y] = '.';
            ch[x + 1][y] = '.';
            ch[x][y + 1] = '.';
            ch[x + 1][y + 1] = '.';
            return true;
        }
    }
}
