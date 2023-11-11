import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class SWEA_18799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < N; j++)
                sum += Integer.parseInt(st.nextToken());

            double avg = (double) sum / N;
            sb.append("#").append(i).append(" ").append(formatNumber(avg)).append("\n");
        }
        System.out.println(sb);
    }

    private static String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("#.####################");
        return df.format(number);
    }
}
