import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
            int result = BFS();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        int[][] minTime = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        minTime[0][0] = 0;

        while (!q.isEmpty()) {
            int[] currentNode = q.poll();
            int x = currentNode[0];
            int y = currentNode[1];
            int time = currentNode[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newTime = time + arr[nx][ny];
                    if (newTime < minTime[nx][ny]) {
                        minTime[nx][ny] = newTime;
                        q.offer(new int[]{nx, ny, newTime});
                    }

                }
            }
        }
        return minTime[N - 1][N - 1];
    }
}
