package ie.gmit;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * Build the huffman tree, the tree is for creating huffman code.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class HuffmanTree {
	private HuffmanNode root;

	/**
	 * 
	 * @return The root node
	 */
	public HuffmanNode getRoot() {
		return root;
	}

	/**
	 * 
	 * @param root
	 */
	public void setRoot(HuffmanNode root) {
		this.root = root;
	}

	/**
	 * Build the huffman tree according to the map
	 * 
	 * @param map
	 * @return The huffman tree
	 */
	public HuffmanTree buildTree(Map<Character, Integer> map) {
		Character[] keys = map.keySet().toArray(new Character[0]);
		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<HuffmanNode>();

		for (Character character : keys) {
			HuffmanNode node = new HuffmanNode();
			node.setChars(character.toString());
			node.setTimes(map.get(character));
			priorityQueue.add(node);
		}

		int size = priorityQueue.size();
		while (priorityQueue.size() > 1) {
			HuffmanNode node1 = priorityQueue.poll();
			HuffmanNode node2 = priorityQueue.poll();

			HuffmanNode sumNode = new HuffmanNode();
			sumNode.setTimes(node1.getTimes() + node2.getTimes());

			sumNode.setLeftNode(node1);
			sumNode.setRightNode(node2);

			node1.setParent(sumNode);
			node2.setParent(sumNode);
			priorityQueue.add(sumNode);
		}

		HuffmanTree tree = new HuffmanTree();
		tree.root = priorityQueue.poll();
		return tree;
	}
}
