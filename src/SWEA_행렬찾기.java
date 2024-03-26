import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_행렬찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            List<int[]> list = new ArrayList<int[]>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != 0) {
                        int row = i;
                        int col = j;
                        while (row + 1 < N && arr[row + 1][j] != 0) {
                            row++;
                        }
                        while (col + 1 < N && arr[i][col + 1] != 0) {
                            col++;
                        }

                        list.add(new int[] { row - i + 1, col - j + 1 });
                        for (int k = i; k <= row; k++) {
                            for (int x = j; x <= col; x++) {
                                arr[k][x] = 0;
                            }
                        }
                    }
                }
            }

            list.sort((a, b) -> {
                int sizeA = a[0] * a[1];
                int sizeB = b[0] * b[1];
                if (sizeA == sizeB) {
                    return a[0] - b[0];
                }
                return sizeA - sizeB;
            });
            bw.write(String.format("#%d %d", tc, list.size()));
            for (int[] temp : list) {
                bw.write(String.format(" %d %d", temp[0], temp[1]));
            }
            bw.write("\n");

        }
        bw.flush();
    }

}