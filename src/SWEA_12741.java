import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int startTime = Math.max(startX, startY);
            int endTime = Math.min(endX, endY);

            int time = endTime - startTime;
            if (time > 0) {
                sb.append("#").append(i).append(" ").append(time).append("\n");
            } else {
                sb.append("#").append(i).append(" ").append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
