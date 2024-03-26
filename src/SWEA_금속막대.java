import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_금속막대 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> reverse = new HashMap<Integer, Integer>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int key = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                map.put(key, val);
                reverse.put(val, key);
            }

            int start = 0;
            for (int key : map.keySet()) {
                if (!reverse.containsKey(key)) {
                    start = key;
                    break;
                }
            }

            bw.write("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                bw.write(start + " " + map.get(start) + " ");
                start = map.get(start);
            }
            bw.write("\n");

        }
        bw.flush();
    }

}