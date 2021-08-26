package test;

public class RotateArray {

	public static void main(String[] args) {
      int[] n= {1,2,3,4,5,6,7};
      int k=3;
      rotate(n,k);
		   
		
	}
	
	 public static void rotate(int[] nums, int k) 
	    {
	      int[] ar1 = nums.clone();
	       for(int i=0;i<nums.length;i++)
	       {
	            nums[(i+k)%nums.length] = ar1[i];
	       }
	      
	    }

}
