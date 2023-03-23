package Com.NodeMaker.Model;

public class NodeConnectionRequest {

	private int node1;
	private int node2;

	public int getNode1() {
		return node1;
	}

	public void setNode1(int node1) {
		this.node1 = node1;
	}

	public int getNode2() {
		return node2;
	}

	public void setNode2(int node2) {
		this.node2 = node2;
	}

	@Override
	public String toString() {
		return "NodeConnectionRequest [node1=" + node1 + ", node2=" + node2 + "]";
	}

}
