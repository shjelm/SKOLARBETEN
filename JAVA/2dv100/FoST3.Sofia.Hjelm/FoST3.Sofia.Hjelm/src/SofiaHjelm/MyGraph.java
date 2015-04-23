package SofiaHjelm;

import graphs.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<E> implements graphs.DirectedGraph<E>  {
	
	private Map<E, MyNode<E>> graph;
	private int numberOfEdges = 0;
	
	public static void main(String args[]){
//		MyGraph<Integer> mGraph = new MyGraph<Integer>();
//		mGraph.addNodeFor(5);
//		mGraph.addNodeFor(9);
//		mGraph.addNodeFor(52);
//		mGraph.addNodeFor(13);
//		System.out.println(mGraph.allItems());
//		
//		mGraph.removeNodeFor(5);
//		System.out.println(mGraph.allItems());
//		
//		System.out.println(mGraph.containsNodeFor(13));
//		System.out.println(mGraph.containsNodeFor(1));
//		
//		System.out.println(mGraph.nodeCount());
//		mGraph.heads();
//		mGraph.headCount();
		
	}
	
	public MyGraph(){
		graph = new LinkedHashMap<E, MyNode<E>>();
	}

	@Override
	public Node<E> addNodeFor(E item) {
		if(item == null){
			throw new NullPointerException();
		}
		
		MyNode<E> node;
		
		if(!graph.containsKey(item)){
			node = new MyNode<E>(item);
			graph.put(item, node);
		}
		else{
			node = graph.get(item);
		}
		return node;
	}

	@Override
	public Node<E> getNodeFor(E item) {
		if(item == null || !graph.containsKey(item)){
			throw new NullPointerException();
		}
		return graph.get(item);		
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new NullPointerException();
		}
		if(graph.get(from) == null){
			addNodeFor(from);
		}
		if(graph.get(to) == null){
			addNodeFor(to);
		}
		
		if(!containsEdgeFor(from, to)){
			numberOfEdges++;
	        graph.get(from).addSucc(graph.get(to));
	        graph.get(to).addPred(graph.get(from)); 
	        return true;
		}
		return false;
	}

	@Override
	public boolean containsNodeFor(E item) {
		if(item == null){
			throw new NullPointerException();
		}
		return graph.containsKey(item);
	}

	@Override
	public int nodeCount() {
		return graph.size();
	}

	@Override
	public Iterator<Node<E>> iterator() {
		Iterator<E> itr = graph.keySet().iterator();
		Map<E, Node<E>> map = new LinkedHashMap<E, Node<E>>();
		while(itr.hasNext()){
			E e= itr.next();
			map.put(e, graph.get(e));
		}
		Iterator<Node<E>> it = map.values().iterator();
		return it;
	}

	@Override
	public Iterator<Node<E>> heads() {
		Iterator<Node<E>> it = iterator();
		Map<E, Node<E>> headsMap = new LinkedHashMap<E, Node<E>>();
		
		while(it.hasNext()){
			Node<E> node = it.next();
			if(node.isHead()){
				 headsMap.put(node.item(), node);
			 }
		}
		 Iterator<Node<E>> itr = headsMap.values().iterator();
		 return itr;
	}

	@Override
	public int headCount() {
		int count = 0;
		Iterator <Node<E>> iter = heads();
		while(iter.hasNext()){
			 count++;
			iter.next();
		 }
		return count;
	}

	@Override
	public Iterator<Node<E>> tails() {
		Iterator<Node<E>> it = iterator();
		Map<E, Node<E>> tailsMap = new LinkedHashMap<E, Node<E>>();
		
		while(it.hasNext()){
			Node<E> node = it.next();
			if(node.isTail()){
				tailsMap.put(node.item(), node);
			 }
		}
		
		 Iterator<Node<E>> itr = tailsMap.values().iterator();
		 return itr;
	}

	@Override
	public int tailCount() {
		int count = 0;
		Iterator <Node<E>> iter = tails();
		while(iter.hasNext()){
			 count++;
			iter.next();
		 }
		return count;
	}

	@Override
	public List<E> allItems() {
		List<E> list = new ArrayList<E>(graph.keySet());
		return list;
	}

	@Override
	public int edgeCount() {
		return numberOfEdges;
	}

	@Override
	public void removeNodeFor(E item) {
		if(item == null || !containsNodeFor(item)){
			throw new NullPointerException();
		}
		int num = graph.get(item).inDegree();
		for(int i = 0; i < num; i++){
			removeEdgeFor(graph.get(item).predsOf().next().item(), item);
		}
		num = graph.get(item).outDegree();
		for(int i = 0; i < num; i++){
			removeEdgeFor(item,graph.get(item).succsOf().next().item());
		}
		
		graph.get(item).disconnect();
		graph.remove(item);
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new NullPointerException();
		}
		
		if(graph.get(from)!= null && graph.get(from).hasSucc(graph.get(to))){
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if(from == null || to == null){
			throw new NullPointerException();
		}
		if(graph.get(from)!= null && graph.get(from).hasSucc(graph.get(to))){
			graph.get(from).removeSucc(graph.get(to));
			graph.get(to).removePred(graph.get(from));
			numberOfEdges--;
			return true;
		}
		return false;
	}

}
