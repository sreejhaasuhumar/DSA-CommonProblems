package test;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left =new TreeNode(2);
		root.right =new TreeNode(3);
		root.right.left=new TreeNode(5);
		root.left.right=new TreeNode(4);
		List<Integer> l= inorderTraversal(root);
		System.out.println(l);
	}
	
	 public static List<Integer> inorderTraversal(TreeNode root) {
	       List<Integer> list=new ArrayList<>();
	       return innerMethod(root,list);
	    }
	    
	    public static List<Integer> innerMethod(TreeNode root,List<Integer> list)
	    {
	        if(root == null)
	          return list;
	        if(root.left != null)
	        	innerMethod(root.left,list);
	        list.add(root.val);
	        if(root.right != null)
	        	innerMethod(root.right,list);
	        return list;
	        
	    }

}
