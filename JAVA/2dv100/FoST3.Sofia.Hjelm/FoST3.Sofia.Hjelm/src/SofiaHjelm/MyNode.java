package SofiaHjelm;

import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyNode<E> extends graphs.Node<E>{
	
	private List<Node<E>> successors = new ArrayList<Node<E>>();
	private List<Node<E>> predecessors = new ArrayList<Node<E>>();
	
	protected MyNode(E item) {
		super(item);
	}

	@Override
	public boolean hasSucc(Node<E> node) {		
		if(successors.contains(node)){
			return true;
		}
		return false;
	}

	@Override
	public int outDegree() {
		return successors.size();
	}

	@Override
	public Iterator<Node<E>> succsOf() {
		Iterator<Node<E>> it = successors.iterator();
		return it;
	}

	@Override
	public boolean hasPred(Node<E> node) {
		if(predecessors.contains(node)){
			return true;
		}
		return false;
	}

	@Override
	public int inDegree() {
		return predecessors.size();
	}

	@Override
	public Iterator<Node<E>> predsOf() {
		Iterator<Node<E>> it = predecessors.iterator();
		return it;
	}

	@Override
	protected void addSucc(Node<E> succ) {
		successors.add(succ);
	}

	@Override
	protected void removeSucc(Node<E> succ) {
		successors.remove(succ);
	}

	@Override
	protected void addPred(Node<E> pred) {
		predecessors.add(pred);
	}

	@Override
	protected void removePred(Node<E> pred) {
		predecessors.remove(pred);
	}

	@Override
	protected void disconnect() {
		successors.clear();
		predecessors.clear();
	}

}
