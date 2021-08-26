package test;

import java.util.Arrays;


public class LongestIncreasingSubsequence {

	/*Given an integer array nums, return the length of the longest strictly increasing subsequence.

			A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

			 

			Example 1:

			Input: nums = [10,9,2,5,3,7,101,18]
			Output: 4
			Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
			*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums= {10,9,2,5,3,7,101,18};
		int ans=lengthOfLIS2(nums);
		System.out.println(ans);
		
	}
	
	 public static int lengthOfLIS(int[] nums) {
		 int[] memo = new int[nums.length];
	        int ans = 0;
	        Arrays.fill(memo,1);
	        for(int i=nums.length-1;i>=0;i--){
	            for(int j=nums.length-1; j>i;j--){
	                if(nums[j] > nums[i]){
	                    memo[i] = Math.max(memo[i],memo[j]+1);
	                }
	            }
	            ans = Math.max(ans,memo[i]);
	        }
	        return ans;
	        } 

	 public static int lengthOfLIS2(int[] nums) {
		 int[] memo = new int[nums.length];
	        int ans = 0;
	        Arrays.fill(memo,1);
	        for(int i=1;i<nums.length;i++){
	            for(int j=0; j<i;j++){
	                if(nums[i] > nums[j]){
	                    memo[i] = Math.max(memo[i],memo[j]+1);
	                }
	            }
	            ans = Math.max(ans,memo[i]);
	        }
	        return ans;
	        } 

}
