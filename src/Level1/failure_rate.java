package Level1;

import java.util.*;

public class failure_rate {
    public int[] solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        int num = stages.length; //현재 총 사용자 수
        Map<Integer, Integer> map = new HashMap<>(); //각 스테이지에 막힌 사용자 수
        Map<Integer, Double> fail = new HashMap<>(); //각 스테이지 별 실패율

        //map 초기화
        for (Integer s : stages) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        //fail 할당
        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(i)) {
                fail.put(i, (double) 0);
            }
            else {
                fail.put(i, map.get(i) / (double)num);
                num -= map.get(i);
            }
        }

        //value를 기준으로 key 정렬
        List<Map.Entry<Integer, Double>> fail_entries = new ArrayList<>(fail.entrySet());
        fail_entries.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(fail_entries);

        for (Map.Entry<Integer, Double> entry : fail_entries) {
            answer.add(entry.getKey());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
