package Level1;

import java.util.HashMap;
import java.util.Map;

public class failed_player {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        //map 초기화
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        //map을 순회하며 완주하지 못한(value==0) 선수 이름 도출
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                answer = e.getKey();
                break;
            }
        }

        return answer;
    }
}
