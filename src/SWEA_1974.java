import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(t).append(" ").append(isValidSudoku(arr) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isValidSudoku(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] column = new boolean[9];
            boolean[] block = new boolean[9];

            for (int j = 0; j < 9; j++) {
                int rowIndex = arr[i][j] - 1;
                int columnIndex = arr[j][i] - 1;
                int blockIndex = arr[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 1;

                if (row[rowIndex] || column[columnIndex] || block[blockIndex])
                    return false;

                row[rowIndex] = column[columnIndex] = block[blockIndex] = true;
            }
        }
        return true;
    }
}
