package SofiaHjelm;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyTransitiveClosure<E> implements graphs.TransitiveClosure<E> {
	private Map<Node<E>, Collection<Node<E>>>  map = new LinkedHashMap<Node<E>, Collection<Node<E>>>();

	/**
	 * Transitive closure for DirectedGrapgh dg
	 */
	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		Iterator<Node<E>> it = dg.iterator();
		MyDFS<E> dfs = new MyDFS<E>();
	
		while(it.hasNext()){			
			Node<E> n = it.next();
			map.put(n, new LinkedList<Node<E>>(dfs.dfs(dg, n))); //Gets all reachable nodes from n and puts them in map
		}
		return map;
	}

}
