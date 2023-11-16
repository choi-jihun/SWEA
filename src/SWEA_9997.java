import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//대체 왜 하나가 통과가 안되는거지??
//이거도 스트링빌더를 쓰면 한 케이스가 통과가 안된다...
public class SWEA_9997 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int h = N / 30 % 12;
            int m = (N % 30) * 2;
            System.out.println("#" + i + " " + h + " " + m);
        }
    }
}
