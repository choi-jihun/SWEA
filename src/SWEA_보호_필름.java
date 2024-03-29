import java.io.*;
import java.util.*;

public class SWEA_보호_필름 {

    static int D, W, K;
    static int[][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[D][W];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            back(0, 0);

            bw.write("#" + tc + " " + ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int idx, int cnt) {
        if (cnt >= ans) {
            return;
        }
        if (idx == D) {
            if (check()) {
                ans = cnt;
            }
            return;
        }

        back(idx + 1, cnt);
        int[] temp = arr[idx].clone();

        Arrays.fill(arr[idx], 0);
        back(idx + 1, cnt + 1);
        arr[idx] = temp.clone();

        Arrays.fill(arr[idx], 1);
        back(idx + 1, cnt + 1);
        arr[idx] = temp.clone();
    }

    static boolean check() {
        for (int i = 0; i < W; i++) {
            int cnt = 1;
            int maxCnt = 1;
            for (int j = 1; j < D; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                } else {
                    cnt = 1;
                }
            }
            if (maxCnt < K) {
                return false;
            }
        }
        return true;
    }

}