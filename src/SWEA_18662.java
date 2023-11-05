import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_18662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            float temp = (float) (x + z) / 2;
            float avg = Math.abs(temp - y);
            //출력 예시엔 0이라고 되어있지만 0.0으로 출력해야 정답이 맞음
            sb.append("#").append(i).append(" ").append(String.format("%.1f", avg)).append("\n");
        }

        System.out.println(sb);
    }
}
