import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rotated90 = rotate90(arr, N);
            int[][] rotated180 = rotate180(arr, N);
            int[][] rotated270 = rotate270(arr, N);

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    sb.append(rotated90[i][j]);
                sb.append(" ");
                for (int j = 0; j < N; j++)
                    sb.append(rotated180[i][j]);
                sb.append(" ");
                for (int j = 0; j < N; j++)
                    sb.append(rotated270[i][j]);
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static int[][] rotate90(int[][] matrix, int N) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    static int[][] rotate180(int[][] matrix, int N) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[N - 1 - i][N - 1 - j] = matrix[i][j];
            }
        }
        return rotated;
    }

    static int[][] rotate270(int[][] matrix, int N) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[N - 1 - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }
}
