package Com.NodeMaker.Service;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NodeService {

	private Map<Integer, Set<Integer>> nodeConnections = new HashMap<>();

	public void joinNodes(int node1, int node2) {
		nodeConnections.computeIfAbsent(node1, k -> new HashSet<>()).add(node2);
		nodeConnections.computeIfAbsent(node2, k -> new HashSet<>()).add(node1);
	}

	public boolean isConnected(int node1, int node2) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node1);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == node2) {
				return true;
			}
			visited.add(current);
			for (int neighbor : nodeConnections.getOrDefault(current, Collections.emptySet())) {
				if (!visited.contains(neighbor)) {
					queue.offer(neighbor);
				}
			}
		}

		return false;
	}
}
