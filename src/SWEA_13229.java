import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//이렇게 제출하면 오류난다...
//public class SWEA_13229 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= T; i++) {
//            String str = br.readLine();
//            switch (str) {
//                case "SUN" -> sb.append("#").append(i).append(" ").append(7).append("\n");
//                case "MON" -> sb.append("#").append(i).append(" ").append(6).append("\n");
//                case "TUE" -> sb.append("#").append(i).append(" ").append(5).append("\n");
//                case "WED" -> sb.append("#").append(i).append(" ").append(4).append("\n");
//                case "THU" -> sb.append("#").append(i).append(" ").append(3).append("\n");
//                case "FRI" -> sb.append("#").append(i).append(" ").append(2).append("\n");
//                case "SAT" -> sb.append("#").append(i).append(" ").append(1).append("\n");
//            }
//        }
//        System.out.println(sb);
//    }
//}

public class SWEA_13229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            switch (str) {
                case "SUN": {
                    sb.append("#").append(i).append(" ").append(7).append("\n");
                    break;
                }
                case "MON": {
                    sb.append("#").append(i).append(" ").append(6).append("\n");
                    break;
                }
                case "TUE": {
                    sb.append("#").append(i).append(" ").append(5).append("\n");
                    break;
                }
                case "WED": {
                    sb.append("#").append(i).append(" ").append(4).append("\n");
                    break;
                }
                case "THU": {
                    sb.append("#").append(i).append(" ").append(3).append("\n");
                    break;
                }
                case "FRI": {
                    sb.append("#").append(i).append(" ").append(2).append("\n");
                    break;
                }
                case "SAT": {
                    sb.append("#").append(i).append(" ").append(1).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}