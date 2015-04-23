package SofiaHjelm;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyTransitiveClosure<E> implements graphs.TransitiveClosure<E> {
	private Map<Node<E>, Collection<Node<E>>>  map = new LinkedHashMap<Node<E>, Collection<Node<E>>>();

	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		//TOOOOOO SLOOOOW :(
		Iterator<Node<E>> it = dg.iterator();
		MyDFS<E> dfs = new MyDFS<E>();
	
		while(it.hasNext()){			
			Node<E> n = it.next();
//			Collection<Node<E>> c = dfs.dfs(dg, n);
			map.put(n, new LinkedList<Node<E>>(dfs.dfs(dg, n)));
		}
		return map;
	}

}
