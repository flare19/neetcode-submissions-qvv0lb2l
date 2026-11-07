class DSU {
    int[] parent;
    DSU(int n) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
    }

    int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if(px == py) return false;
        parent[px] = py;
        return true;
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        DSU dsu = new DSU(nums.length);
        HashMap<Integer, Integer> primeMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            Set<Integer> primes = getPrime(nums[i]);
            for(int prime : primes) {
                if(primeMap.containsKey(prime)) {
                    dsu.union(i, primeMap.get(prime));
                    continue;
                }
                primeMap.putIfAbsent(prime, i);
            }
        }
        int flag = 0;
        for(int i=0; i<nums.length; i++) {
            if(dsu.find(i) != dsu.find(0)) flag++;
        }
        return flag == 0;
    }

    private Set<Integer> getPrime(int num) {
        Set<Integer> res = new HashSet<>();

        while(num % 2 == 0) {
            res.add(2);
            num /= 2;
        }

        for(int i=3; i * i <= num; i++) {
            while(num % i == 0) {
                res.add(i);
                num /= i;
            }
        }

        if(num > 1) {
            res.add(num);
        }

        return res;
    }
}