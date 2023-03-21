package Level2;

public class 피로도 {
    boolean[] visited; //각 던전의 탐험 여부
    int answer = -1;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    //탐험한 던전의 수, 현재 피로도, 던전
    public void dfs(int count, int current_k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > current_k) {
                continue;
            }

            visited[i] = true;
            dfs(count + 1, current_k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, count);
    }
}
