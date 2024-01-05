import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int []A = new int [N];
            int []B = new int [M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int maxSum = findMaxSum(N, M, A, B);
            sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
        }
        System.out.println(sb);
    }

    static int findMaxSum(int N, int M, int[] A, int[] B) {
        int maxSum = 0;

        if (N < M) {
            for (int i = 0; i <= M - N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += A[j] * B[i + j];
                }
                maxSum = Math.max(maxSum, sum);
            }
        } else {
            for (int i = 0; i <= N - M; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += A[i + j] * B[j];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
