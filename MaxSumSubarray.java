package test;

public class MaxSumSubarray {

	public static void main(String[] args) {

		int[] nums = {-2,2,-1,7,1,-5,2};
		int ans=maxSumSubarray(nums);
		System.out.println(ans);
	}
	
	public static int maxSumSubarray(int[] nums) {
		int currStart =0,
		currMax =0,
		max = 0,
		maxStart =0,
		maxEnd =0;
		
		for(int i=0;i<nums.length;i++)
		{
			currMax =currMax+nums[i];
			if(currMax<0)
			{
				currMax=0;
				currStart=i+1;
			}
			
			if(currMax>max)
			{
				maxStart=currStart;
				maxEnd=i;
				max=currMax;
			}		
			
		}
		
		return max;
		 
	}

}
