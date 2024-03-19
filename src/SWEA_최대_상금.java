import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_최대_상금 {

    static int[] arr;
    static int ans;
    static int len;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            int N = Integer.parseInt(st.nextToken());
            len = str.length();
            arr = new int[len];
            ans = -1;

            for (int i = 0; i < len; i++) {
                arr[i] = str.charAt(i) - '0';
            }
            findMax(N, 0, 0);
            bw.write("#" + tc + " " + ans + "\n");
        }

        bw.flush();
    }

    public static void findMax(int n, int start, int value) {
        if (n == 0 || start >= len) {
            ans = Math.max(ans, value);
            return;
        }

        int maxValue = -1;
        for (int i = start; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(i, j);
                int num = makeNum();
                if (num > maxValue) {
                    maxValue = num;
                    findMax(n - 1, i, num);
                }
                swap(i, j);
            }
        }
    }

    static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int makeNum() {
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp += Math.pow(10, len - (i + 1)) * arr[i];
        }

        return temp;
    }

}
