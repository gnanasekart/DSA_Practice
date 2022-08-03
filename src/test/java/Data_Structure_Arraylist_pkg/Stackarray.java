package Data_Structure_Arraylist_pkg;

public class Stackarray
{
static final int MAX = 100;
int top ;
int a[] = new int[MAX];

Stackarray()
{
	top = -1;
}
boolean isEmpty()
{
	return (top < 0);
}

boolean push(int element)
{
	if(top >= (MAX - 1))
	{
		System.out.println("stock overflow");
		return false;	
}
else
{
	a[++top] = element;
System.out.println(element +" is new element");
return true;
}
}

int pop()
{
	if(top<0)
	{
		System.out.println("stack underflow");
		return 0;
	}
	else
	{
		int x = a[top--];
		return x;
	}
}

public void printelement()
{
	for(int i=0; i<=top; i++)
	{
		System.out.println(a[i]);
	}
	System.out.println();
}

public static void main(String[] args)
{
	Stackarray arr = new Stackarray();
	arr.push(1);
	arr.push(3);
	arr.printelement();
	arr.pop();
	arr.printelement();
}
}