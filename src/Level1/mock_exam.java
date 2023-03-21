package Level1;

import java.util.ArrayList;
/*
모의고사
https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class mock_exam {
    public int[] solution(int[] answers) {
        int count = 0;
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];

            if (arr1[i % 5] == ans) {
                score[0] += 1;
            }
            if (arr2[i % 8] == ans) {
                score[1] += 1;
            }
            if (arr3[i % 10] == ans) {
                score[2] += 1;
            }
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();

        for (int s : score) {
            count += 1;
            if (s == max) {
                list.add(count);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(list);

        return answer;
    }
}
