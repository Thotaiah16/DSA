class Solution {
public:
    long long minimumCost(vector<int>& nums, int k, int dist) {
        multiset<long long> small, large;
        long long sumSmall = 0;
        long long ans = LLONG_MAX;

        auto add = [&](long long x) {
            if (small.size() < k - 1) {
                small.insert(x);
                sumSmall += x;
            } else if (!small.empty() && x < *prev(small.end())) {
                large.insert(*prev(small.end()));
                sumSmall -= *prev(small.end());
                small.erase(prev(small.end()));
                small.insert(x);
                sumSmall += x;
            } else {
                large.insert(x);
            }
        };

        auto remove = [&](long long x) {
            if (small.find(x) != small.end()) {
                small.erase(small.find(x));
                sumSmall -= x;
                if (!large.empty()) {
                    small.insert(*large.begin());
                    sumSmall += *large.begin();
                    large.erase(large.begin());
                }
            } else {
                large.erase(large.find(x));
            }
        };

        // initial window
        for (int i = 1; i <= dist + 1; i++) {
            add(nums[i]);
        }

        ans = sumSmall;

        // slide window
        for (int i = dist + 2; i < nums.size(); i++) {
            remove(nums[i - (dist + 1)]);
            add(nums[i]);
            ans = min(ans, sumSmall);
        }

        return nums[0] + ans;
    }
};
