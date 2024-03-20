import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_19185 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] str1 = br.readLine().split(" ");
            String[] str2 = br.readLine().split(" ");

            int year = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < year; i++) {
                int temp = Integer.parseInt(br.readLine());
                sb.append(str1[(temp - 1) % N]).append(str2[(temp - 1) % M]).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
