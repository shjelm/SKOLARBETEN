package SofiaHjelm;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {

	private Collection<Collection<Node<E>>> coll = new LinkedList<Collection<Node<E>>>();
	private List<Node<E>> marked = new LinkedList<Node<E>>();
	
	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {

	      Queue<Node<E>> queue = new LinkedList<Node<E>>();
	      MyDFS<E> dfs = new MyDFS<E>();
	      
	      Iterator<Node<E>> it = dg.iterator();
			while(it.hasNext()){
				Node<E> n = it.next();
				
				if(n.isHead()){
					dfs.dfs(dg, n);
				}
			}	      

	      
		return coll;
	}

}
