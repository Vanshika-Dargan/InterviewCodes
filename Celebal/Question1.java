public class Question1 {

    public static int[] cal(int[] profit, int[] query) {
        int[] ans = new int[query.length];
        boolean[] visited = new boolean[profit.length];
        helper(visited, 0, profit, query, 0, ans, profit.length);
        return ans;
    }

    private static void helper(boolean[] visited, int day, int[] profit, int[] query, int net, int[] ans, int days) {
        if (day == days) {
            for (int i = 0; i < query.length; i++) {
                if (net >= query[i]) {
                    ans[i] += 1;
                }
            }
            return;
        }
        for (int i = 0; i < profit.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int curr_profit = (int) (profit[i] * 1.0 / Math.pow(2, day));
                helper(visited, day + 1, profit, query, net + curr_profit, ans, days);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] profit = {10,3};
        int[] query = {10};
        int[] result = cal(profit, query);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
