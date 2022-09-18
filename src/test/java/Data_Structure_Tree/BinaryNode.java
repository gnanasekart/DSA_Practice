package Data_Structure_Tree;
public class BinaryNode
{
	String value;
	BinaryNode left, right;
	int height;

	public void node(String item)
	{
		value = item;
		left = right = null;
	}
}
