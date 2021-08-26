package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class paypal {

	public static void main(String[] args) {

		int l=31;
		int r=32;
		int sree=isHappy(l,r);
		System.out.println(sree);
	}

	    private static int getNext(int n) {
	        int totalSum = 0;
	        while (n > 0) {
	            int d = n % 10;
	            n = n / 10;
	            totalSum += d * d;
	        }
	        return totalSum;
	    }
	    public static int isHappy(int l,int r) {
	        Set<Integer> seen = new HashSet<>();
	        ArrayList<Integer> arr=new ArrayList<>();
	        while(l<=r)
	        {
	        	int temp=l;
	        while (l != 1 && !seen.contains(l)) {
	            seen.add(l);
	            l = getNext(l);
	        }
//	        seen.clear();
	        if(l == 1)
	        	arr.add(temp);
	        l=temp;
	        l++;
	    }
	        int result=0;
	        for(int i=0;i<arr.size();i++)
	        {
	        	result+=arr.get(i);
	        }
	        
	        return result;
	}
	    
//	    void pre()
//	    {
//	    	Integer[] tot=new Array[];
//	    	for(int i=0;i<=1000000;i++)
//	    	{
//	    		if(getNext(i))
//	    		{
//	    			tot[i]=i;
//	    		}
//	    	}
//	    	for(int i=0;i<=1000000;i++)
//	    	{
//	    		tot[i]=tot[i]+tot[i-1];
//	    	}
//	    }

}
