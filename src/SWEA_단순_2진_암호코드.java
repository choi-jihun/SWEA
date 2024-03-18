import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_단순_2진_암호코드 {

    static String[] str = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
            "0110111", "0001011" };
    static int[] temp;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] arr = new String[N];
            temp = new int[8];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }

            String t = "";
            label: for (int i = 0; i < N; i++) {
                for (int j = M - 1; j >= 0; j--) {
                    if (arr[i].charAt(j) == '1') {
                        t = arr[i].substring(j - 55, j + 1);
                        break label;
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                String temp2 = t.substring(i * 7, i * 7 + 7);
                for (int j = 0; j < 10; j++) {
                    if (temp2.equals(str[j])) {
                        temp[i] = j;
                    }
                }
            }

            int sum = 0;
            int ans = 0;
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    sum += temp[i] * 3;
                    ans += temp[i];
                } else {
                    sum += temp[i];
                    ans += temp[i];
                }
            }
            bw.write("#" + tc + " " + ((sum % 10 == 0) ? ans : 0) + "\n");
        }
        bw.flush();
    }

}
