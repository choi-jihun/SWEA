import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_Magnetic {

    static int[][] arr = new int[100][100];

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test = 1; test <= 10; test++) {
            br.readLine();
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < 100; i++) {
                cnt += count(i);
            }
            sb.append("#").append(test).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }

    static int count(int x) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 100; i++) {
            if (arr[i][x] == 1) {
                stack.push(arr[x][i]);
            }
            if (arr[i][x] == 2) {
                if (!stack.isEmpty()) {
                    cnt++;
                    stack.clear();
                }
            }
        }
        return cnt;
    }

}
