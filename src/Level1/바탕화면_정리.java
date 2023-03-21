package Level1;

public class 바탕화면_정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length, wallpaper[0].length(), 1, 1};

        for (int i = 0; i < wallpaper.length; i++) {
            String str = wallpaper[i];
            if (!str.contains("#"))
                continue;

            answer[0] = Math.min(answer[0], i); //lux
            answer[1] = Math.min(answer[1], str.indexOf("#")); //luy
            answer[2] = Math.max(answer[2], i + 1); //rdx
            answer[3] = Math.max(answer[3], str.lastIndexOf("#") + 1); //rdy
        }

        return answer;
    }
}
