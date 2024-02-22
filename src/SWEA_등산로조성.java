import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_등산로조성 {

    static int[][] arr;
    static int N, K, max;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] isVisited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            isVisited = new boolean[N][N];
            max = -1;
            int maxDepth = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxDepth = Math.max(maxDepth, arr[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (maxDepth == arr[i][j]) {
                        isVisited[i][j] = true;
                        dfs(i, j, arr[i][j], 1, false);
                        isVisited[i][j] = false;
                    }
                }
            }
            bw.write("#" + test + " " + max + "\n");
        }
        bw.flush();

    }

    static void dfs(int x, int y, int height, int len, boolean dig) {
        max = Math.max(len, max);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValid(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (height > arr[nextX][nextY]) {
                    isVisited[nextX][nextY] = true;
                    dfs(nextX, nextY, arr[nextX][nextY], len + 1, dig);
                    isVisited[nextX][nextY] = false;
                } else if (height > arr[nextX][nextY] - K && !dig) {
                    isVisited[nextX][nextY] = true;
                    dfs(nextX, nextY, height - 1, len + 1, true);
                    isVisited[nextX][nextY] = false;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
