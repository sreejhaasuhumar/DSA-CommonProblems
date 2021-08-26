package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	/*Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

*/

	public static void main(String[] args) {

		int[] nums = {2,2,1,1,1,2,2};
		int ans=majorityElement(nums);
		System.out.println(ans);
	}
	
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++)
        {
        	map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        
//        Integer maxEntry = Collections.max(map.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
        int maxEntry=0;
        for(Integer i:map.keySet())
        {
        	if(map.get(i)>(nums.length)/2)
        		 maxEntry=i;
        }
    return maxEntry;
    }
    
    public static int majorityElement2(int[] nums) {
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }     
    
   

}
