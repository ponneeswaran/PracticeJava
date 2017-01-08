import java.util.*;

/**
 * Amazon Interview Topological Sorting
 */

/**
 * @author Ponneeswaran
 *
 */
public class TopoSortDFS {
	private int vertices;
	private LinkedList<Integer> adj[];
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public TopoSortDFS(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int u, int v){
		adj[u].add(v);
	}
	
	public void topoSortUtil(int v, boolean[] discovered, Stack<Integer> stack){
		
		discovered[v]=true;
		int i;
		
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()){
			i=it.next();
			if(!discovered[i]){
				topoSortUtil(i, discovered, stack);
			}
		}
		
		stack.push(v);
	}
	
	public void topologicalSort(int start){
		Stack<Integer> stack = new Stack<Integer>();
		boolean discovered[] = new boolean[vertices];
		for(int i=0;i<vertices;i++)
			discovered[i] = false;
		
		topoSortUtil(start,discovered,stack);
		
		for(int i=0;i<vertices;i++)
			if(discovered[i]==false)
				topoSortUtil(i,discovered,stack);
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TopoSortDFS graph = new TopoSortDFS(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 6);
		graph.addEdge(1, 5);
		graph.addEdge(1, 6);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 0);
		graph.addEdge(3, 1);
		graph.addEdge(4, 5);
		graph.addEdge(6, 5);
		
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		
		graph.topologicalSort(start);
		
		sc.close();
	}

}
