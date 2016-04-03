package leetcode.jh.P001_TwoSum;

import java.util.HashMap;
import java.util.Vector;

import static java.lang.Integer.min;
import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by jh on 16-4-2.
 */
public class P001 {

     public class Solution {
         public int[] twoSum(int[] nums, int target) {
             int []results=new int[2];
             HashMap<Integer,Vector<Integer>> map=new HashMap<>();
             for (int index=0;index<nums.length;++index){
                int num=nums[index];
                if (!map.containsKey(num)){
                    Vector<Integer> indices=new Vector<>();
                    indices.add(index);
                    map.put(num,indices);
                }else{
                    map.get(num).add(index);
                }
             }

             for (int index=0;index<nums.length;++index){
                 int num=nums[index];
                 int diff=target-num;
                 if (map.containsKey(diff)){
                     Vector<Integer> indices=map.get(diff);
                     //one thing to pay attention to is diff may coincide with num
                     if (diff!=num && indices.size()>0){
                         /*
                         int mi=min(indices.get(0),index);
                         int ma=max(indices.get(0),index);
                         results[0]=mi;
                         results[1]=ma;
                         */
                         results[0]=index;
                         results[1]=indices.get(0);
                         break;
                     }else if (diff==num && indices.size()>1){
                         results[0]=indices.get(0);
                         results[1]=indices.get(1);
                     }
                 }
             }

             return results;
         }
     }

     public void test(){
         Solution solution=new Solution();
         int [] test=new int[]{0,2,4,0};
         int [] results=solution.twoSum(test,4);
         System.out.println(results[0]+" "+results[1]);
     }

}
