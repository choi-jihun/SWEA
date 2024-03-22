import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_2819 {

    static int[][] arr;
    static Set<String> set;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            arr = new int[4][4];
            sb = new StringBuilder();
            set = new HashSet<String>();
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(0, i, j);
                }
            }
            bw.write(String.format("#%d %d\n", tc, set.size()));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth, int x, int y) {
        if (depth == 7) {
            set.add(sb.toString());
            return;
        }

        sb.append(arr[x][y]);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny)) {
                dfs(depth + 1, nx, ny);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
}
