package test;

public class MaxSumRectangle {

	/*Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
*/
	
	//use kadane's algorithm
	public static void main(String[] args) {

		int[][] matrix = {{1,0,1},{0,-2,3}};
		int k = 2;
		int ans=maxSumRectangle(matrix,k);
		System.out.println(ans);
	}
	
	public static int maxSumRectangle(int[][] matrix , int k) {
		int rows = matrix.length;
		int cols =matrix[0].length;
		int[] temp = new int[rows];
		Resultsum rSum=new Resultsum();
		for(int left=0;left < cols;left++)
		{
			for(int i=0;i< rows;i++)
			{
				temp[i]=0;
			}
			
			for(int right=left;right < cols;right++)
			{
				for(int i=0;i<rows;i++)
				{
					temp[i]=temp[i]+matrix[i][right];
				}
				
				KadaneResult kSum= KadaneResult.kadane(temp);
				if(kSum.maxSum>rSum.max && kSum.maxSum<=2)
				{
					rSum.max=kSum.maxSum;
					rSum.left=left;
					rSum.right=right;
					rSum.up=kSum.start;
					rSum.down=kSum.end;
				}
				
			}
			
		}
		return rSum.max;

	}

}
