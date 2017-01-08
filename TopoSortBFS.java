import java.util.*;

/**
 * 
 */

/**
 * @author Ponneeswaran
 *
 */
public class TopoSortBFS {
	private int vertices;
	private LinkedList<Integer> adj[];
	private List<String> color;
	private LinkedList<Integer> finished;
	
	/**
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TopoSortBFS(int v) {
		vertices = v;
		adj = new LinkedList[v];
		color = new ArrayList();
		finished = new LinkedList();
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<Integer>();
			color.add(i, "white");;
		}
	}
	
	public void addEdge(int u, int v){
		adj[u].add(v);
	}

	public void topologicalSort(int start){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int j;
		int v;
		
		for(int i=0;i<vertices;i++){
			if(start!=0 && color.get(start).equalsIgnoreCase("white")){
				v = start;
				i--;
			}
			else{
				v = i;
			}
			if(color.get(v).equalsIgnoreCase("white")){
				color.set(v, "grey");
				queue.add(v);
				while(!queue.isEmpty()){
					int u = queue.getFirst();
					Iterator<Integer> it = adj[u].iterator();
					while(it.hasNext()){
						j = it.next();
						if(color.get(j).equalsIgnoreCase("white")){
							color.set(j, "grey");
							queue.add(j);
						}
					}
					int k = queue.removeFirst();
					color.set(k, "black");
					finished.addFirst(k);
				}
			}
		}
		
		while(!finished.isEmpty()){
			System.out.print(finished.pop() + " ");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopoSortBFS graph = new TopoSortBFS(2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 6);
//		graph.addEdge(1, 5);
//		graph.addEdge(1, 6);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 3);
//		graph.addEdge(2, 4);
//		graph.addEdge(3, 0);
//		graph.addEdge(3, 1);
//		graph.addEdge(4, 5);
//		graph.addEdge(6, 5);
		
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		
		graph.topologicalSort(start);
		
		sc.close();
	}

}
