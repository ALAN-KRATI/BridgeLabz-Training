class IntersectionArrays{
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans  = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]) ans.add(nums1[i]);
            }
        }

        int[] res = new int[ans.size()];
        int x = 0;

        for(int k : ans){
            res[x++] = k;
        }

        return res;
    }
}