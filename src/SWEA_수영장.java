import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_수영장 {

    static int[] ticket;
    static int[] month;
    static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            ticket = new int[4];
            month = new int[12];
            dp = new int[12];

            for (int i = 0; i < 4; i++) {
                ticket[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }

            int minPay = Math.min(findMinPay(0), ticket[3]);
            bw.write("#" + test + " " + minPay + "\n");
        }
        bw.flush();
    }

    static int findMinPay(int idx) {
        if (idx >= 12) {
            return 0;
        }

        if (month[idx] == 0) {
            findMinPay(idx + 1);
        }

        int dayTicket = ticket[0] * month[idx] + findMinPay(idx + 1);
        int oneMonthTicket = ticket[1] + findMinPay(idx + 1);
        int threeMonthTicket = ticket[2] + findMinPay(idx + 3);

        dp[idx] = Math.min(dayTicket, Math.min(oneMonthTicket, threeMonthTicket));

        return dp[idx];
    }

}
