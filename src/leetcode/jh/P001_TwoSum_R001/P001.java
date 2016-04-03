package leetcode.jh.P001_TwoSum_R001;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by jh on 16-4-3.
 */
public class P001 {
    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            int [] results=new int[2];
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int i=0;i<nums.length;++i){
                if (map.containsKey(target-nums[i])){
                    results[0]=map.get(target-nums[i]);
                    results[1]=i;
                    break;
                }else{
                    map.put(nums[i],i);
                }
            }
            return results;
        }
    }

    public void test(){
        Solution solution=new Solution();
        int [] test=new int[]{0,2,4,0};
        int [] results=solution.twoSum(test,2);
        System.out.println(results[0]+" "+results[1]);
    }
}
