import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//마지막 테스트 케이스에 줄바꿈을 없애면 통과된다..
//진짜 뭐지...
public class SWEA_9940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            if (i != T) {
                if (set.size() != N) {
                    sb.append("#").append(i).append(" No\n");
                } else {
                    sb.append("#").append(i).append(" Yes\n");
                }
            } else {
                if (set.size() != N) {
                    sb.append("#").append(i).append(" No");
                } else {
                    sb.append("#").append(i).append(" Yes");
                }
            }
        }
        System.out.println(sb);
    }
}
