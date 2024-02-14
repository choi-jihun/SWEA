import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Ladder1 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr = new int[100][100];
    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test = 1; test <= 10; test++) {
            br.readLine();
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            for (int j = 0; j < 100; j++) {
                if (arr[99][j] == 2) {
                    ans = bfs(99, j);
                }
            }
            sb.append("#").append(test).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        boolean[][] visited = new boolean[100][100];
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        int ans = y;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 2; i++) {
                int curX = node.x;
                int curY = node.y + dx[i];

                if (isValid(curX, curY) && !visited[curX][curY] && arr[curX][curY] == 1) {
                    visited[curX][curY] = true;
                    q.offer(new Node(curX, curY));
                    ans = curY;
                    break;
                }
            }

            if (q.isEmpty()) {
                int curX = node.x - 1;
                int curY = node.y;

                if (isValid(curX, curY) && !visited[curX][curY] && arr[curX][curY] == 1) {
                    visited[curX][curY] = true;
                    q.offer(new Node(curX, curY));
                    ans = curY;
                }
            }
        }
        return ans;
    }



    static boolean isValid(int x, int y) {
        return x >= 0 && x < 100 && y >= 0 && y < 100;
    }

}
