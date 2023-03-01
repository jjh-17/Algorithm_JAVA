package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dart_game {
    public int solution(String dartResult) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>() {{
            put('S', 1);
            put('D', 2);
            put('T', 3);
        }};

        List<Integer> scoreList = new ArrayList<>();
        int score = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if ('0' <= c && c <= '9') {
                //점수
                if (c == '0' && i > 0 && dartResult.charAt(i - 1) == '1') {
                    score = 10;
                } else {
                    score = Character.getNumericValue(c);
                }
            } else if (map.containsKey(c)) {
                //보너스
                scoreList.add((int)Math.pow(score, map.get(c)));
            } else{
                //옵션
                if (c == '*') {
                    //스타상
                    int length = scoreList.size();
                    for (int j = 1; j <= Math.min(length, 2); j++) {
                        scoreList.set(length - j, scoreList.get(length - j) * 2);
                    }

                } else {
                    //아차상
                    scoreList.set(scoreList.size() - 1, -scoreList.get(scoreList.size() - 1));
                }
            }
        }

        answer = scoreList.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }
}
