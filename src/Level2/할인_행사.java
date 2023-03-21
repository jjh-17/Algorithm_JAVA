package Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean flag;
        int total = 0;

        for (int n : number) {
            total += n;
        }
        
        for (int i = 0; i <= discount.length - total; i++) {
            flag = true;
            //want_map
            Map<String, Integer> want_map = new HashMap<>() {
                {
                    for (int i = 0; i < want.length; i++) {
                        put(want[i], number[i]);
                    }
                }
            };
//            System.out.println("<i = " + i + ">");
//            System.out.println("want_map = " + want_map);
            String[] arr = Arrays.copyOfRange(discount, i, i + 10);

            for (String s : arr) {
                //want에 없거나, 물건을 만족할 만큼 사지 못하는 경우
                if (want_map.getOrDefault(s, 0) == 0) {
//                    System.out.println("arr = " + Arrays.toString(arr));
//                    System.out.println("s = " + s);
                    flag = false;
                    break;
                }
                want_map.put(s, want_map.get(s) - 1);
//                System.out.println("want_map = " + want_map);
            }

            //다음 i 값으로 다시 수행
            if(!flag)
                continue;
            answer += 1;
        }

        return answer;
    }
}
