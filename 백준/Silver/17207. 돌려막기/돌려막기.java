import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] difficulty = new int[5][5];
        int[][] expectedTime = new int[5][5];
        String[] nameList = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};
        int[] totalLoad = new int[5];
        int minTotalLoad = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                if (i < 5) {
                    difficulty[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    expectedTime[i - 5][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    totalLoad[i] += difficulty[i][k] * expectedTime[k][j];
                }
            }
            if (totalLoad[i] < minTotalLoad) {
                minTotalLoad = totalLoad[i];
            }
        }

        int idx = 4;
        while (idx >= 0) {
            if (totalLoad[idx] == minTotalLoad) {
                System.out.println(nameList[idx]);
                break;
            }
            idx--;
        }

        br.close();
    }
}