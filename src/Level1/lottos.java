package Level1;

import java.util.*;
/*
https://school.programmers.co.kr/learn/courses/30/lessons/77484
로또의 최고 순위와 최저 순위
 */
public class lottos {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int max = 0; //맞춘 최대 개수
        int min = 0; //맞춘 최저 개수

        for (int l : lottos) {
            if (l == 0) {
                max += 1;
            } else {
                for (int w : win_nums) {
                    if (w == l) {
                        max += 1;
                        min += 1;
                        break;
                    }
                }
            }
        }

        answer[0] = Math.min(6, 7 - max); //당첨 순위 최고
        answer[1] = Math.min(6, 7 - min); //당첨 순위 최저

        return answer;
    }
}
