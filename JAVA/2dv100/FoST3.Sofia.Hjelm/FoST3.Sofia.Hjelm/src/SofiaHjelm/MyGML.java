package SofiaHjelm;

import java.util.Iterator;
import java.util.Map;

import graphs.DirectedGraph;
import graphs.Node;

public class MyGML<E> extends graphs.GML{
	DirectedGraph<E> graph;

	public MyGML(DirectedGraph dg) {
		super(dg);
		graph = dg;
	}

	@Override
	public String toGML() {
		String nodeGML ="DirectedGraph\n";
		for(int i = 0; i < graph.allItems().size(); i++){
			Node<E> node =graph.getNodeFor(graph.allItems().get(i));
			nodeGML += "node [ id " + node.item() + "\nlabel \"" + node.item() + "\"\n]\n";
		}
		for(int i = 0; i < graph.allItems().size(); i++){
			Node<E> node =graph.getNodeFor(graph.allItems().get(i));
			Iterator<Node<E>> succs = node.succsOf();
			Iterator<Node<E>> preds = node.predsOf();
			
			while(succs.hasNext()){
				Node<E> next = succs.next();
				nodeGML += "edge [\nsource " + node.item() + " target " +next.item() + 
						"\nlabel 'Edge from node "+ node.item()+" to node "+ next.item() +"'\n]\n";
			}
			while(preds.hasNext()){
				Node<E> next = preds.next();
				nodeGML += "edge [\nsource " + next.item() + " target " +node.item() + 
						"\nlabel 'Edge from node "+ next.item()+" to node "+ node.item() +"'\n]\n";
			}
		}
		return nodeGML;
	}

}
