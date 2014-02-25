package ie.gmit;

/**
 * Creating the huffman nodes.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
	private String chars;
	private int times;
	private HuffmanNode parent;
	private HuffmanNode leftNode;
	private HuffmanNode rightNode;

	@Override
	public int compareTo(HuffmanNode o) {
		return times - o.times;

	}

	/**
	 * Judge if it is a leaf node
	 * 
	 * @return The weight of the char
	 */
	public boolean isLeaf() {
		return chars.length() == 1;
	}

	/**
	 * Judge if it is root node
	 * 
	 * @return No parent
	 */
	public boolean isRoot() {
		return parent == null;
	}

	/**
	 * Judge if it is the left child
	 * 
	 * @return Have parent, and it is lift child
	 */
	public boolean isLeftChild() {
		return parent != null && this == parent.leftNode;
	}

	/**
	 * 
	 * @return Get the character
	 */
	public String getChars() {
		return chars;
	}

	/**
	 * 
	 * @param chars
	 */
	public void setChars(String chars) {
		this.chars = chars;
	}

	/**
	 * 
	 * @return Get the character's appear times
	 */
	public int getTimes() {
		return times;
	}

	/**
	 * 
	 * @param times
	 */
	public void setTimes(int times) {
		this.times = times;
	}

	/**
	 * 
	 * @return Get the Node's parent
	 */
	public HuffmanNode getParent() {
		return parent;
	}

	/**
	 * 
	 * @param parent
	 */
	public void setParent(HuffmanNode parent) {
		this.parent = parent;
	}

	/**
	 * 
	 * @return Get the node's left node
	 */
	public HuffmanNode getLeftNode() {
		return leftNode;
	}

	/**
	 * 
	 * @param leftNode
	 */
	public void setLeftNode(HuffmanNode leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * 
	 * @return Get the node's right node
	 */
	public HuffmanNode getRightNode() {
		return rightNode;
	}

	/**
	 * 
	 * @param rightNode
	 */
	public void setRightNode(HuffmanNode rightNode) {
		this.rightNode = rightNode;
	}

}
