import java.io.*;
import java.util.*;

public class SWEA_활주로_건설 {

    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (canBuild(i, true)) count++;
                if (canBuild(i, false)) count++;
            }

            bw.write("#" + tc + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean canBuild(int index, boolean direction) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int curr = direction ? map[index][i] : map[i][index];
            int next = direction ? map[index][i + 1] : map[i + 1][index];

            if (curr == next)
                continue;

            int diff = curr - next;

            if (diff == 1) {
                for (int j = i + 1; j <= i + X; j++) {
                    if (j >= N || visited[j] || (direction ? map[index][j] : map[j][index]) != next)
                        return false;
                    visited[j] = true;
                }
            } else if (diff == -1) {
                for (int j = i; j > i - X; j--) {
                    if (j < 0 || visited[j] || (direction ? map[index][j] : map[j][index]) != curr)
                        return false;
                    visited[j] = true;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
