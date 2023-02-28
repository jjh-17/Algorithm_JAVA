package Level1;

/*
부족한 금액 계산하기
https://school.programmers.co.kr/learn/courses/30/lessons/82612
 */
public class calculate_scarce_cost {
    public long soulution(int price, int money, int count) {
        long answer = -1;
        long cost = 0; //내야할 총 금액

        for (int i = 0; i <= count; i++) {
            cost += (long) price * i;
        }

        //0과 '내야할 금액 - 가용 금액' 중 큰 값
        answer = Math.max(0, cost - money);

        return answer;
    }
}
