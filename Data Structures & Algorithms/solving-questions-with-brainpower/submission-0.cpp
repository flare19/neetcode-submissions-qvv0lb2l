class Solution {
    vector<long long> dp;
public:
    long long mostPoints(vector<vector<int>>& questions) {
        dp.resize(questions.size(), -1);
        return dfs(0, questions);
    }

private:
    long long dfs(int i, vector<vector<int>>& questions) {
        if (i >= questions.size()) {
            return 0;
        }
        int score = questions[i][0];
        int skip = questions[i][1];
        if (dp[i] != -1) return dp[i];
        long long res = max(score + dfs(i+1+skip, questions), dfs(i+1, questions));
        dp[i] = res;
        return res;
    }
};
