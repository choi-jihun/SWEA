import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Sum {
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
            int maxSum = 0;
            for (int i = 0; i < 100; i++) {
                maxSum = Math.max(getDia(i), Math.max(getWidth(i), Math.max(maxSum, getLength(i))));
            }
            sb.append("#").append(test).append(" ").append(maxSum).append("\n");
        }
        System.out.println(sb);
    }

    static int getLength(int x) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += arr[x][i];
            max = Math.max(max, sum);
        }
        return max;
    }

    static int getWidth(int x) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += arr[i][x];
            max = Math.max(max, sum);
        }
        return max;
    }

    static int getDia(int x) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 100 - x; i++) {
            sum += arr[x + i][x + i];
            max = Math.max(max, sum);
        }
        return max;
    }

}
