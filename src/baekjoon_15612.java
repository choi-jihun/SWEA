import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_15612 {
    static int[][] rock = new int[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            char[][] ch = new char[8][8];
            for (int[] row : rock) {
                Arrays.fill(row, 0);
            }
            for (int j = 0; j < 8; j++) {
                ch[j] = br.readLine().toCharArray();
                for (int k = 0; k < 8; k++) {
                    if (ch[j][k] == 'O') {
                        rock[j][k] += 1;
                    }
                }
            }
            if (checkRow() && checkCol() && checkCount()) {
                sb.append("#").append(i).append(" ").append("yes").append("\n");
            } else {
                sb.append("#").append(i).append(" ").append("no").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean checkRow() {
        for (int j = 0; j < 8; j++) {
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                cnt += rock[j][k];
                if (cnt >= 2)
                    return false;
            }
        }
        return true;
    }

    static boolean checkCol() {
        for (int j = 0; j < 8; j++) {
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                cnt += rock[k][j];
                if (cnt >= 2)
                    return false;
            }
        }
        return true;
    }

    static boolean checkCount() {
        int cnt = 0;
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                cnt += rock[j][k];
            }
        }
        return cnt == 8;
    }
}
