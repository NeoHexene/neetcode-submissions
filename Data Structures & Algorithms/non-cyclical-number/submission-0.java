class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (true) {
            int mod = n % 10;
            sum += mod * mod;
            n = n / 10;
            if (n == 0 && sum != 0) {
                if (sum == 1) {
                    return true;
                }
                if (set.contains(sum)) {
                    return false;
                }
                n = sum;
                set.add(sum);
                sum = 0;
            }
        }
    }
}
