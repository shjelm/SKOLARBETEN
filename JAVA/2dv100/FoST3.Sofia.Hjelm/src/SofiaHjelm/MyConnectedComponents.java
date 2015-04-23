package SofiaHjelm;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {

	private List<Node<E>> nodes = new LinkedList<Node<E>>();
	private List<Collection<Node<E>>> list = new LinkedList<Collection<Node<E>>>();
	
	/**
	 * Gets all connected components for graph dg
	 */
	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		list.clear();
		MyDFS<E> dfs = new MyDFS<E>();
		List<Node<E>> newList = new LinkedList<Node<E>>();
	      
		Iterator<Node<E>> it = dg.iterator();
			while(it.hasNext()){
			Node<E> n = it.next();
			List<Node<E>> dfsList = dfs.dfs(dg, n);
			
				if(!nodes.contains(n)){
					Iterator<Node<E>> iter = dfsList.iterator();
					
					while(iter.hasNext()){
						Node<E> k = iter.next();
						if(nodes.contains(k)){
							for(int i = 0; i < list.size(); i++){
								if(!dfsList.contains(newList)){ //Check if nodes exists in multiple components
									if(list.get(i).contains(k)){ 
										Iterator<Node<E>> get = list.get(i).iterator();
										list.remove(i); //Remove the collection of nodes that contains multiple
										while(get.hasNext()){
											if(!newList.contains(k)){
												newList.addAll(dfsList); //Add connected components
											}
											Node<E> next = get.next();
											if(!newList.contains(next)){
												newList.add(next); //Add nodes from collection previously removed
											}
										}
									}	
								}
							}
						}
						nodes.add(k);
					}
					if(newList.size() > 0){ //Check if merged
						dfsList = newList;
					}
					list.add(new LinkedHashSet<Node<E>>(dfsList));
					newList.clear(); //When merged list added, clear it 
				}
			}	 
			return list;
	}

}
