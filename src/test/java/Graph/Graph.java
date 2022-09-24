package Graph;
import java.util.LinkedList;
public class Graph
{
int vertexcount;
LinkedList<Integer> adjll[];

@SuppressWarnings("unchecked")
Graph(int v)
{
	this.vertexcount = v;
	adjll = new LinkedList[vertexcount];
	for(int i=0; i < vertexcount; i++)
	{
		adjll[i] = new LinkedList();
	}
}

public void printgraph()
{
for(int v=0; v < this.vertexcount; v++)
{
System.out.println("vertix for "+v+" is : ");
for(Integer var : adjll[v])
{
	System.out.print("-->" +var);
}
System.out.println("\n");
}
}


void addedges(int start, int end)
{
adjll[start].add(end);
adjll[end].add(start);
}	

public static void main(String[] args)
{
Graph graph = new Graph(5);
graph.addedges(0, 1);
graph.addedges(0, 4);
graph.addedges(1, 2);
graph.addedges(1, 3);
graph.addedges(1, 4);
graph.addedges(2, 3);
graph.addedges(3, 4);

graph.printgraph();
}
}