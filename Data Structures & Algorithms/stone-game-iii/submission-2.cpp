class Solution {
public:
    vector<int> dp;
    string stoneGameIII(vector<int>& stoneValue) {
        dp.resize(stoneValue.size(), INT_MIN);
        int res = dfs(0, stoneValue);
        if (res > 0) {
            return "Alice";
        } else if (res < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

private:
    int dfs(int i, vector<int>& stones) {
        if (i >= stones.size()) {
            return 0;
        }
        if (dp[i] != INT_MIN) return dp[i];
        int sum = 0;
        int total = INT_MIN;

        for (int j=i; j<min(i+3, static_cast<int>(stones.size())); j++) {
            sum += stones[j];
            total = max(total, sum - dfs(j+1, stones));
        }
        dp[i] = total;
        return total;
    }
};