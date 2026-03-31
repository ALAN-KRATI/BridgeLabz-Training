class HouseRobber{
    
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0]; 
        int n = nums.length-1;
        int[] dp = new int[n+1];
       
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i = 2; i <= n; i++){
            int y = Integer.MIN_VALUE;
            for(int j = 2; j <= n; j++){
                if(i-j < 0) break;
                int x = dp[i-j];
                y = Math.max(x, y);
            }
            dp[i] = y + nums[i];
        }


        return Math.max(dp[n], dp[n-1]);
    }
}