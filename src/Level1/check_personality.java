package Level1;

import java.util.HashMap;
import java.util.Map;

/*
성격 유형 검사하기
https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class check_personality {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        int length = survey.length;
        int strCompare = 0;

        //Map 초기화
        for (String t : types) {
            map.put(t, 0);
        }

        //순회
        for (int i = 0; i < length; i++) {
            String type = "";
            int score = 0;

            if (choices[i] < 4){
                type = survey[i].substring(0, 1);
                score = 4 - choices[i];
            }
             else if (choices[i] > 4) {
                type = survey[i].substring(1, 2);
                score = choices[i] - 4;
            }else
                continue;

            map.put(type, map.get(type) + score);
        }

        //RT 비교
        if (map.get("R") < map.get("T"))
            answer += "T";
        else
            answer += "R";

        //CF 비교
        if (map.get("C") < map.get("F"))
            answer += "F";
        else
            answer += "C";

        //JM 비교
        if (map.get("J") < map.get("M"))
            answer += "M";
        else
            answer += "J";

        //AN 비교
        if (map.get("A") < map.get("N"))
            answer += "N";
        else
            answer += "A";



        return answer;
    }
}
