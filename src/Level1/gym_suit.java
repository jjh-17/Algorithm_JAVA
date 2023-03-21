package Level1;

import java.util.Arrays;
import java.util.HashSet;

public class gym_suit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여벌 체육복이 도난 당함
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer += 1;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        //여벌 체육복을 빌려줌
        for (int k : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if (k == reserve[j] - 1 || k == reserve[j] + 1) {
                    answer += 1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
