import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfMelonsPerArea = Integer.parseInt(br.readLine());

        int[] length = new int[6];

        int maxWidth = Integer.MIN_VALUE, maxWidthIdx = 0;
        int maxHight = Integer.MIN_VALUE, maxHightIdx = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());

            if (direction == 1 | direction == 2) {
                if (length[i] > maxWidth) {
                    maxWidth = length[i];
                    maxWidthIdx = i;
                }
            } else {
                if (length[i] > maxHight) {
                    maxHight = length[i];
                    maxHightIdx = i;
                }
            }
        }

        int maxArea = maxWidth * maxHight;
        int blankArea = length[(maxWidthIdx + 3) % 6] * length[(maxHightIdx + 3) % 6];
        int totalArea = maxArea - blankArea;

        System.out.println(totalArea * numberOfMelonsPerArea);
        br.close();
    }
}