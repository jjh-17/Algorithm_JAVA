package Level1;

import java.util.*;

public class min_rectangle {
    public int solution(int[][] sizes) {
        //max1은 최고 길이, max2는 최저 길이
        int max1=0, max2=0;
        int temp1, temp2;

        for (int[] size : sizes) {
            temp1 = Math.max(size[0], size[1]);
            temp2 = Math.min(size[0], size[1]);
            max1 = Math.max(temp1, max1);
            max2 = Math.max(temp2, max2);
        }

        return max1 * max2;
    }
}
