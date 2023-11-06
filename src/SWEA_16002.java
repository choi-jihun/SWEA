import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_16002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int temp = 4;
            while (true) {
                if (!isPrime(temp) && !isPrime(temp + N)) {
                    sb.append("#").append(i).append(" ").append(temp + N).append(" ").append(temp).append("\n");
                    break;
                } else {
                    temp++;
                }
            }
        }
        System.out.println(sb);
    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
