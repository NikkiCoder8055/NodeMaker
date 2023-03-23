package Com.NodeMaker.Nodetester;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import Com.NodeMaker.Model.*;

import Com.NodeMaker.Service.NodeService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NodeControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private NodeService nodeService;

	@Test
	public void testJoinNodes() {
		NodeConnectionRequest request = new NodeConnectionRequest();
		request.setNode1(1);
		request.setNode2(2);
		ResponseEntity<String> response = restTemplate.postForEntity("/api/nodes/join", request, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(nodeService.isConnected(1, 2)).isTrue();
	}

	@Test
	public void testIsConnected() {
		NodeConnectionRequest request = new NodeConnectionRequest();
		request.setNode1(1);
		request.setNode2(2);
		nodeService.joinNodes(1, 2);
		boolean isConnected = restTemplate.getForObject("/api/nodes/isConnected?node1=1&node2=2", Boolean.class);
		assertThat(isConnected).isTrue();
	}
}
