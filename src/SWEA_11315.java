import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315 {
    static char[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            for (int j = 0; j < N; j++) {
                arr[j] = br.readLine().toCharArray();
            }

            if (checkCol() || checkRow() || checkDia()) {
                sb.append("#").append(i).append(" YES\n");
            } else {
                sb.append("#").append(i).append(" NO\n");
            }
        }
        System.out.println(sb);
    }

    static boolean checkRow() {
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'o') {
                    cnt++;
                }
                if (cnt == 5) {
                    return true;
                } else if (arr[i][j] != 'o') {
                    cnt = 0;
                }
            }
        }
        return false;
    }

    static boolean checkCol() {
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 'o') {
                    cnt++;
                }
                if (cnt == 5) {
                    return true;
                } else if (arr[j][i] != 'o') {
                    cnt = 0;
                }
            }
        }
        return false;
    }

    static boolean checkDia() {
        for (int i = 0; i <= N - 5; i++) {
            for (int j = 0; j <= N - 5; j++) {
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (arr[i + k][j + k] == 'o') {
                        cnt++;
                    }
                }
                if (cnt == 5) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= N - 5; i++) {
            for (int j = 4; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (arr[i + k][j - k] == 'o') {
                        cnt++;
                    }
                }
                if (cnt == 5) {
                    return true;
                }
            }
        }

        return false;
    }
}
