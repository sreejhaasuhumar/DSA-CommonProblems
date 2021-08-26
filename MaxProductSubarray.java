package test;

public class MaxProductSubarray {
//	private static int max=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int[] nums = {2,4,-2,7};
		int ans=maxProduct2(nums);
		System.out.println(ans);

	}
	
	public static int maxProduct(int[] nums) {
        int currStart =0,
		currMax =1,
		max=0,
		maxStart =0,
		maxEnd =0;
		
		for(int i=0;i<nums.length;i++)
		{
//			currMax=1;
			currMax =currMax*nums[i];
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
	
	public static int maxProduct2(int[] nums) {

	int max=nums[0];
	int min = nums[0];
	int ans=nums[0];

	for(int i=1;i<nums.length;i++){
	    int premax=max;
	    max=Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
	       min=Math.min(nums[i],Math.min(premax*nums[i],min*nums[i]));
	ans=Math.max(max,ans);
	    
	    }
	return ans;
	}



}
