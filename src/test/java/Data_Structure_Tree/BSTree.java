package Data_Structure_Tree;
public class BSTree
{
puiblic static Node search(Node root, int key)
{
if(root == null || root.key == key)
{
	return root;
}
else if(key < root.key)
{
return search(root.left, key);
}
return search(root.right, int key);
}	

public static void main(String[] args)
{
	           8
		      /	\
            4    12
           /  \  /  \
          1    7 9  14		   
	*/
		
	BSTree bst = new BSTree(8);
	bst.root.left = new Node (4);
	bst.root.right = new Node (12);
	bst.root.left.left = new Node(1);
	bst.root.left.right = new Node(7);
	bst.root.right.left = new Node(9);
	bst.root.right.right = new Node(14);
	
	bst.insert
	
	bst.root = new Node(  
BSTree.search(BSTree.root, 1).

}
}


