import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = maxVal(arr, N, M);

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static int maxVal(int[][] arr, int N, int M) {
        int maxFly = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxFly = Math.max(maxFly, flies(arr, i, j, N, M, true));
                maxFly = Math.max(maxFly, flies(arr, i, j, N, M, false));
            }
        }
        return maxFly;
    }

    static int flies(int[][] arr, int x, int y, int N, int M, boolean isPlus) {
        int flies = arr[x][y];
        if (isPlus) {
            for (int i = 1; i < M; i++) {
                if (x + i < N)
                    flies += arr[x + i][y];
                if (x - i >= 0)
                    flies += arr[x - i][y];
                if (y + i < N)
                    flies += arr[x][y + i];
                if (y - i >= 0)
                    flies += arr[x][y - i];
            }
        } else {
            for (int i = 1; i < M; i++) {
                if (x + i < N && y + i < N)
                    flies += arr[x + i][y + i];
                if (x + i < N && y - i >= 0)
                    flies += arr[x + i][y - i];
                if (x - i >= 0 && y + i < N)
                    flies += arr[x - i][y + i];
                if (x - i >= 0 && y - i >= 0)
                    flies += arr[x - i][y - i];
            }
        }
        return flies;
    }
}
