package test;

public class KadaneResult {
        int maxSum;
        int start;
        int end;
        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
        
        public static KadaneResult kadane(int[] nums) {
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
    		
    		return new KadaneResult(max, maxStart, maxEnd);
    		 
    	}
    }

