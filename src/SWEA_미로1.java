import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SWEA_미로1 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int test = 1; test <= 10; test++) {
            br.readLine();
            arr = new int[16][16];
            visited = new boolean[16][16];

            int startX = 0, startY = 0;
            for (int i = 0; i < 16; i++) {
                String str = br.readLine();
                for (int j = 0; j < 16; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            bw.write("#" + test + " " + (bfs(startX, startY) ? 1 : 0) + "\n");
            bw.flush();
        }
    }

    static boolean bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Node> que = new LinkedList<Node>();
        que.offer(new Node(x, y));
        visited[x][y] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if (isValid(nextX, nextY)) {
                    if (arr[nextX][nextY] == 3) {
                        return true;
                    }
                    que.offer(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return false;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 16 && y >= 0 && y < 16 && arr[x][y] != 1 && !visited[x][y];
    }

}
