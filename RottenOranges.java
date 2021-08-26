package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {

		int[][] grid= {{2,1,1},{1,1,0},{0,1,1}};
		int ans = orangesRotting2(grid);
		System.out.println(ans);
		
		
	}

public static int orangesRotting(int[][] grid) {//dont use this
	int mins=0;
	boolean b=false;
	for(int i=0;i<grid.length;i++)
	{
		for(int j=0;j<grid[0].length;j++)
		{
			if(grid[i][j]==2)
			{
				b=false;
				if(i+1<3 && j>=0 && grid[i+1][j]==1)
				{
					grid[i+1][j]=2;
					b=true;
				}
				if(i-1>=0 && j>=0 && grid[i-1][j]==1)
				{
					grid[i-1][j]=2;
					b=true;
				}
				if( i>=0 && j+1<3 && grid[i][j+1]==1)
				{
					grid[i][j+1]=2;
				    b=true;
		     	}
				if(i>=0 && j-1>=0 && grid[i][j-1]==1)
				{
					grid[i][j-1]=2;
			    	b=true;
		        }
				if(b==true)
		     		mins++;			
					
			}
		}
        
    }
	List<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<grid.length;i++)
	{
		for(int j=0;j<grid[0].length;j++)
		{
			list.add(grid[i][j]);
		}
	}
	return list.contains(1)?-1:mins;
}

public static int orangesRotting2(int[][] grid) {//use this
	int m=grid.length;
	int n=grid[0].length;
	int ans =0;

	
	Queue<DirElement> q=new LinkedList<>();
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(grid[i][j]==2)
			{
				q.offer(new DirElement(i, j));
			}
			if(grid[i][j]==1)
			{
				if(i+1<3 && i-1>=0 && j+1<3 && j-1>=0)
				{
					if(grid[i+1][j]==0 && grid[i-1][j]==0 && grid[i][j+1]==0 && grid[i][j-1]==0)
						return -1;
				}
			}
		}
	}
	
	while(!q.isEmpty())
	{
		boolean b=false;
		int size=q.size();
		for(int i=0;i<size;i++)
		{
			DirElement dir=q.poll();
			int x=dir.x;
			int y=dir.y;
			
			//right
			if(x+1<3 && x>=0 && y<3 && y>=0)
			{
				if(grid[x+1][y]==1)
				{
					b=true;
					grid[x+1][y]=2;
					q.offer(new DirElement(x+1, y));
				}
			}
			
			//left
			if(x-1>=3 && x<3 && y<3 && y>=0)
			{
				if(grid[x-1][y]==1)
				{
					b=true;
					grid[x-1][y]=2;
					q.offer(new DirElement(x-1, y));
				}
			}
			
			//up
			if(x<3 && x>=0 && y+1<3 && y>=0)
			{
				if(grid[x][y+1]==1)
				{
					b=true;
					grid[x][y+1]=2;
					q.offer(new DirElement(x, y+1));
				}
			}
			
			//down
			if(x<3 && x>=0 && y<3 && y-1>=0)
			{
				if(grid[x][y-1]==1)
				{
					b=true;
					grid[x][y-1]=2;
					q.offer(new DirElement(x, y-1));
				}
			}
			
			
			
//			for(int k=0;k<m;k++)
//			{
//				for(int j=0;j<n;j++)
//				{
//					if(grid[k][j]==1)
//					{
//						return -1;
//					}
//					}
//			}
		}
		
		if(b==true)
			ans++;
		else
			break;
	}
	
	return ans;
	
}

}

