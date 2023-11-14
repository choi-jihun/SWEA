import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
    static int N;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            writeMap();
            sb.append("#").append(i).append("\n");
            for (int j = N - 1; j >= 0; j--) {
                for (int k = N - 1; k >= 0; k--)
                    sb.append(arr[j][k]).append(" ");
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void writeMap() {
        int x = N - 1, y = N - 1, dir = 0;
        int num = 1;

        while (num <= N * N) {
            arr[x][y] = num++;
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || arr[nextX][nextY] != 0) {
                dir = (dir + 1) % 4;
            }

            x += dx[dir];
            y += dy[dir];
        }
    }
}
