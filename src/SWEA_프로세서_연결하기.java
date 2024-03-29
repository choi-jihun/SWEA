import java.io.*;
import java.util.*;

public class SWEA_프로세서_연결하기 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int maxCoreCount;
    static int ans;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static ArrayList<int[]> cores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            cores.add(new int[] { i, j });
                        }
                    }
                }
            }
            size = cores.size();
            ans = Integer.MAX_VALUE;
            maxCoreCount = 0;
            back(0, 0, 0);
            bw.write("#" + tc + " " + ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int size;

    static void back(int index, int connectedCores, int length) {
        if (size - index + connectedCores < maxCoreCount)
            return;
        if (index == cores.size()) {
            if (maxCoreCount < connectedCores) {
                maxCoreCount = connectedCores;
                ans = length;
            } else if (maxCoreCount == connectedCores) {
                ans = Math.min(ans, length);
            }
            return;
        }

        int[] core = cores.get(index);
        int x = core[0];
        int y = core[1];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int len = 0;
            while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arr[nx][ny] != 0)
                    break;
                nx += dx[i];
                ny += dy[i];
                len++;
            }

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                link(x, y, i, len);
                back(index + 1, connectedCores + 1, length + len);
                unlink(x, y, i, len);
            }
            back(index + 1, connectedCores, length);
        }
    }

    static void link(int x, int y, int dir, int len) {
        for (int i = 0; i < len; i++) {
            x += dx[dir];
            y += dy[dir];
            arr[x][y] = 2;
        }
    }

    static void unlink(int x, int y, int dir, int len) {
        for (int i = 0; i < len; i++) {
            x += dx[dir];
            y += dy[dir];
            arr[x][y] = 0;
        }
    }
}
