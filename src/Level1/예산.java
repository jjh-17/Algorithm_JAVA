package Level1;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12982
public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (Integer i : d) {
            if (i > budget)
                break;

            answer += 1;
            budget -= i;
        }

        return answer;
    }
}
