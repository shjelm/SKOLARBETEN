package SofiaHjelm;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MyBFS<E> implements graphs.BFS<E> {
	
	List<Node<E>> visited = new ArrayList<Node<E>>();
	private int bfNr = 0;
	
	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		visited.clear();
		visited.add(root);
		Set<Node<E>> s = new LinkedHashSet<Node<E>>();
		s.add(root);
		bfs(s);
		return visited;
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		int count = 0;
		visited.clear();
		Set<Node<E>> s = new LinkedHashSet<Node<E>>();
		Iterator<Node<E>> it = graph.iterator();
		while(it.hasNext()){
			Node<E> n = it.next();
			if(n.isHead()){
				count++;
				s.add(n);
				if(count > 1){
					visited.add(n);
				}
				bfs(s);
				if(count == 1){
					visited.add(n);
				}
				
			}
		}
		return visited;
	}
	
	public void bfs(Set<Node<E>> s) {
		
		if(!s.isEmpty()){
			Set<Node<E>> s2 = new LinkedHashSet<Node<E>>();
			Iterator<Node<E>> it = s.iterator();
			while(it.hasNext()){				
				Node<E> k = it.next();
				k.num = bfNr++;
				
				Iterator<Node<E>> iter = k.succsOf();
				
				while(iter.hasNext()){
					
					Node<E> n = iter.next();
					if(!visited.contains(n)){
						visited.add(n);
						s2.add(n);						
						}
					}
			}
			bfs(s2);
		}
	}
}
