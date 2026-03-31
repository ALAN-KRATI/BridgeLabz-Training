class ClimbingStairs{
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
       

        int a = 1;
        int b = 1;
        
        for(int i = 2; i <= n; i++){
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}