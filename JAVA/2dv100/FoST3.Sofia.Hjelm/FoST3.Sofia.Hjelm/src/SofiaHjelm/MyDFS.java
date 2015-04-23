package SofiaHjelm;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyDFS<E> implements graphs.DFS<E> {
	

	private List<Node<E>> visited = new LinkedList<Node<E>>(), inProgress = new LinkedList<Node<E>>(), 
			visited2 = new LinkedList<Node<E>>(), postOrder = new LinkedList<Node<E>>();
    
	private int dfNr = 0, poNr = 0;
    
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph,Node<E> root){
		visited.clear();
		return dfs(root);
	}

	private List<Node<E>> dfs(Node<E> n) {
		visited.add(n);
		
		Iterator<Node<E>> it = n.succsOf();
		
		n.num = dfNr++;
		
		while(it.hasNext()){
			Node<E> node = it.next();
			if(!visited.contains(node)){
				dfs(node);
			}
		}		
		return visited;
	}

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		Iterator<Node<E>> it = graph.iterator();
		while(it.hasNext()){
			Node<E> n = it.next();
			if(n.isHead()){
				visited2 = dfs(n);
			}
		}
		return visited2;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g,Node<E> root) {
		visited.clear();		
		postOrder.clear();
		return postOrder(root, postOrder);
	}
	
	private List<Node<E>> postOrder(Node<E> n, List<Node<E>> poList) {
		visited.add(n);
		
		Iterator<Node<E>> it = n.succsOf();
		
		while(it.hasNext()){
			Node<E> node = it.next();
			if(!visited.contains(node)){
				postOrder(node,poList);
			}
		}	
		
		n.num = dfNr++;	
		postOrder.add(n);
		
		return postOrder;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		Iterator<Node<E>> it = g.iterator();
		while(it.hasNext()){
			Node<E> n = it.next();
			if(n.isHead()){
				visited2 = postOrder(n, postOrder);
			}
		}
		return visited2;
	}
	
	
	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		Iterator<Node<E>> it = g.iterator();
		while(it.hasNext()){
			Node<E> n = it.next();
			if(n.isHead()){
				visited2 = postOrder(n, postOrder);
			}
			if(attach_dfs_number){
				n.num = dfNr++;	
			}
			else{
				n.num= poNr++;
			}
		}
		
		return visited2;
	}
	
	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		visited.clear();
		for(Node<E> k: graph){
			if(!visited.contains(k)){
				if(hasCycle(k)){
					return true;
				}
			}
		}
	    return false;
	}
	
	private boolean hasCycle(Node<E> node) {
		inProgress.add(node);
		Iterator<Node<E>> it = node.succsOf();
		List<Node<E>> list = new LinkedList<Node<E>>();
		
		while(it.hasNext()){
			list.add(it.next());
		}
		
	    for (Node<E> m : list) {
	        if (inProgress.contains(m)){
	            return true;
	        }
	        if (visited.contains(m)) {
	            if (hasCycle(m)) {
	                return true;
	            }
	        }
	    }
	    visited.add(node);
	    return false;
	}

	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		List<Node<E>> list = postOrder(graph);
		List<Node<E>> topList = new LinkedList<Node<E>>();
		
		for(int i = list.size()-1; i >= 0; i--){
			topList.add(list.get(i));
		}
		return topList;
	}

}
