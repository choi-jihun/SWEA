import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_20551 {

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
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            boolean flag = false;
            for (int i = 2; i > 0; i--) {
                if (arr[i] <= arr[i - 1]) {
                    int temp = arr[i - 1] - (arr[i - 1] - arr[i]) - 1;
                    cnt += (arr[i - 1] - arr[i]) + 1;
                    arr[i - 1] = temp;
                    if (temp <= 0) {
                        flag = true;
                    }
                }
            }
            bw.write("#" + tc + " " + (flag == true ? -1 : cnt) + "\n");
        }

        bw.flush();
    }

}
