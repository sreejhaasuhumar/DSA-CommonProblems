package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElement2 {
/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/
	public static void main(String[] args) {

		Integer[] nums = {2,2,8,6,5,1,1,1,2,2};
		List<Integer> ans=majorityElement(nums);
		System.out.println(ans);
		
	}
	
    public static List<Integer> majorityElement(Integer[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int gap=length/3;
        for(int i=0;i<length && length > i+gap;i++)
        {
        	if(nums[i]==nums[gap+i])
        	{
        		set.add(nums[i]);
        	}
        }
        
        list.addAll(set);
        return list;
        
    }

}
