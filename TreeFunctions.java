package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left =new TreeNode(2);
		root.right =new TreeNode(3);
		root.right.left=new TreeNode(5);
		root.left.right=new TreeNode(4);
		System.out.println(root);
		List<Integer> ans=new ArrayList<>();

		List<List<Integer>> l= levelOrder(root);
		List<Integer> l1=preOrderTraversal(root,ans);
		isSymmetric(root);
		System.out.println(l);
		System.out.println(l1);



	}
	
	    public static List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> ans = new ArrayList<>();
	        Queue<TreeNode> q = new LinkedList<>();
	        if (root != null) {
	            q.offer(root);
	        }
	        TreeNode cur;
	        while (!q.isEmpty()) {
	            int size = q.size();
	            List<Integer> subAns = new LinkedList<Integer>();
	            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
	                cur = q.poll();
	                subAns.add(cur.val);                // visit the root
	                if (cur.left != null) {
	                    q.offer(cur.left);              // push left child to queue if it is not null
	                }
	                if (cur.right != null) {
	                    q.offer(cur.right);             // push right child to queue if it is not null
	                }
	            }
	            ans.add(subAns);
	        }
	        return ans;
	    }
	
	    public static List<Integer> preOrderTraversal(TreeNode root,List<Integer> l)
	    {
	    	    	
	    	if(root!=null)
	    	{
	    		l.add(root.val);
	    		if(root.left!=null)
	    		{
	    			preOrderTraversal(root.left,l);
	    		}
	    		if(root.right!=null)
	    		{
	    			preOrderTraversal(root.right,l);
	    		}
	    	}
	    	
	    	return l;
	    	
	    }
	    
	    public static void isSymmetric(TreeNode root)
	    {
	    	boolean b=isMirror(root,root);
	    	
	    }
	    
	    public static boolean isMirror(TreeNode t1,TreeNode t2)
	    {
	    	if (t1 == null && t2 == null) return true;
	        if (t1 == null || t2 == null) return false;
	        return (t1.val == t2.val)
	            && isMirror(t1.right, t2.left)
	            && isMirror(t1.left, t2.right);
	    }

	    public boolean hasPathSum(TreeNode root, int sum) {
	        if (root == null)
	          return false;

	        sum -= root.val;
	        if ((root.left == null) && (root.right == null))
	          return (sum == 0);
	        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	      }
}
