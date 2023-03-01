package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class expiration_date {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        //약관 map화
        for (String t : terms) {
            String[] tArr = t.split(" ");
            map.put(tArr[0], Integer.valueOf(tArr[1]));
        }

        //privacy 순회
        for (String p : privacies) {
            count += 1;
            String[] pArr = p.split(" ");
            String date = pArr[0];
            String term = pArr[1];

            String[] dateArr = date.split("\\.");
            int year = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int day = Integer.parseInt(dateArr[2]);

            //expiration date 도출
            year += (int) (map.get(term) / 12);
            month += (int) (map.get(term) % 12);
            if (month > 12) {
                year += 1;
                month -= 12;
            }
            day -= 1;
            if (day == 0) {
                month -= 1;
                day = 28;
                if (month == 0) {
                    year -= 1;
                    month = 12;
                }
            }

            String expirationDate = "0".repeat(3 - (int) Math.log10(year)) + year + "."
                    + "0".repeat(1 - (int) Math.log10(month)) + month + "."
                    + "0".repeat(1 - (int) Math.log10(day)) + day;
            if(today.compareTo(expirationDate) > 0)
                answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
