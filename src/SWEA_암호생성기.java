import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_암호생성기 {

    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;

        for (int test = 1; test <= 10; test++) {
            br.readLine();
            que = new LinkedList<>();
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }
            Encryption();
            sb.append("#").append(test);
            while (!que.isEmpty()) {
                sb.append(" ").append(que.poll());
            }
            bw.write(sb + "\n");
            bw.flush();
        }
    }

    static void Encryption() {
        int temp = -1;
        while (true) {
            for (int i = 1; i <= 5; i++) {
                temp = que.poll();
                temp -= i;
                if (temp <= 0) {
                    que.offer(0);
                    return;
                }
                que.offer(temp);
            }
        }
    }

}
