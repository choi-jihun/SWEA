import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_정사각형방 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int[][] arr;
    static boolean[][] isVisited;
    static int cnt, N, max;
    static int minNum;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = -1;
            minNum = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i, j);
                }
            }
            bw.write("#" + test + " " + minNum + " " + max + "\n");
        }
        bw.flush();
    }

    static void bfs(int x, int y) {
        isVisited = new boolean[N][N];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y));
        isVisited[x][y] = true;
        cnt = 1;

        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                if (isValid(nextX, nextY) && !isVisited[nextX][nextY]) {
                    if (Math.abs(arr[node.x][node.y] - arr[nextX][nextY]) == 1) {
                        cnt++;
                        isVisited[nextX][nextY] = true;
                        que.offer(new Node(nextX, nextY));
                        if (cnt > max) {
                            max = cnt;
                            minNum = arr[x][y];
                        } else if (cnt == max && arr[x][y] < minNum) {
                            minNum = arr[x][y];
                        }
                    }
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
