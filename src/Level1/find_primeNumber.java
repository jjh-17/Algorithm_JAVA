package Level1;


import java.util.ArrayList;

public class find_primeNumber {
    public int solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[n+1]; //false로 초기화

        //에라토스테네스의 체
        for (int i = 2; i <= n; i++) {
            if (!flag[i]) {
                list.add(i);
                for (int j = 2 * i; j <= n; j += i) {
                    flag[j] = true;
                }
            }
        }

        return list.size();
    }
}
