package Level2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java
public class 모음_사전 {
    public int solution(String word) {
        /*
        [각 자리수에 따른 순서 값 변경]
        5번째 자리 : +1
        4번째 자리 : +6
        3번째 자리 : +31
        2번째 자리 : +156
        1번째 자리 : +781
         */

        int answer = 0;
        int[] arr = {781, 156, 31, 6, 1};
        Map<Character, Integer> map = new HashMap<>() {{
            put('A', 0);
            put('E', 1);
            put('I', 2);
            put('O', 3);
            put('U', 4);
        }};


        //문자열 순회
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            answer += arr[i] * map.get(c) + 1;
        }

        return answer;
    }
}
