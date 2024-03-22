import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_7728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            boolean[] arr = new boolean[10];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - '0'] = true;
            }

            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (arr[i]) {
                    cnt++;
                }
            }

            bw.write(String.format("#%d %d\n", tc, cnt));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
