package Level1;

import java.util.ArrayList;
import java.util.HashMap;

public class get_report_result {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reported_map = new HashMap<>();            //유저 별 신고당한 횟수
        HashMap<String, ArrayList<String>> report_map = new HashMap<>();      //유저 별 신고한 ID 목록


        //report 순회
        for (String r : report) {
            String user = r.split(" ")[0];
            String reported = r.split(" ")[1];

            ArrayList<String> arr = report_map.getOrDefault(user, new ArrayList<>());
            if (!arr.contains(reported)) {
                arr.add(reported);
                reported_map.put(reported, reported_map.getOrDefault(reported, 0) + 1);
            }
            report_map.put(user, arr);
        }

        //id_list 순회
        int count = 0;
        for (String id : id_list) {
            for (String reported : report_map.getOrDefault(id, new ArrayList<>())) {
                if (reported_map.getOrDefault(reported, 0) >= k) {
                    answer[count] += 1;
                }
            }
            count += 1;
        }

        return answer;
    }
}
