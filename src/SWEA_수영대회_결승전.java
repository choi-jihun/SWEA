import java.io.*;
import java.util.*;

public class SWEA_수영대회_결승전 {

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N;
    static int[][] arr;
    static int[][] dp;
    static int startX, startY;
    static int endX, endY;
    static int time;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            dp[startX][startY] = 0;

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs();
            bw.write(String.format("#%d %d\n", tc, (dp[endX][endY] == Integer.MAX_VALUE) ? -1 : dp[endX][endY]));
        }
        bw.flush();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nextTime = node.time;

                if (isValid(nx, ny)) {
                    int waitTime = 0;
                    if (arr[nx][ny] == 2) {
                        if (nextTime % 3 != 2) {
                            waitTime = (2 - nextTime % 3);
                        }
                    }

                    int arrivalTime = nextTime + 1 + waitTime;
                    if (dp[nx][ny] > arrivalTime) {
                        dp[nx][ny] = arrivalTime;
                        q.offer(new Node(nx, ny, arrivalTime));
                    }
                }
            }
        }
    }


    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && arr[x][y] != 1;
    }
}
