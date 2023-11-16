import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이거도 스트링빌더 쓰면 테케하나 남기고 오류난다ㅋㅋㅋ..
public class SWEA_9839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (a, b) -> b - a);
            int max = -1;
            breakLoop:
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = arr[j] * arr[k];
                    if (check(temp)) {
                        max = temp;
                        break breakLoop;
                    }
                }
            }
            System.out.println("#" + i + " " + max);
        }
    }

    static boolean check(int x) {
        int lastDigit = -1;
        while (x > 0) {
            int currentDigit = x % 10;
            if (lastDigit != -1 && lastDigit - currentDigit != 1) {
                return false;
            }
            lastDigit = currentDigit;
            x /= 10;
        }
        return true;
    }
}
