package test;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
*/
public class GoodNode {
	public static int count=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left =new TreeNode(1);
		root.right =new TreeNode(4);
		root.right.left=new TreeNode(1);
		root.right.right=new TreeNode(5);
		root.left.left =new TreeNode(3);
		int ans=goodNodes(root);
		System.out.println(ans);

		
	}

    public static int goodNodes(TreeNode root) {
    	goodNodesInt(root,0);
    	return count;
    }
    
    public static void goodNodesInt(TreeNode root,int max) {
        if(root==null)
        	return;
        if(root.val>=max)
        {
        	count++;
        	max=root.val;
        }
      	goodNodesInt(root.left,max);
       	goodNodesInt(root.right,max);
    }
}
