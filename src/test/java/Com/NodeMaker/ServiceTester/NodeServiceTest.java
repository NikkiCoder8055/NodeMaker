package Com.NodeMaker.ServiceTester;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import Com.NodeMaker.Service.NodeService;

@SpringBootTest
class NodeServiceTest {

    @Autowired
    private NodeService nodeService;

    @Test
    void testJoinNodes() {
        nodeService.joinNodes(1, 2);
        assertTrue(nodeService.isConnected(1, 2));
    }

    @Test
    void testIsConnected() {
        nodeService.joinNodes(1, 2);
        nodeService.joinNodes(2, 3);
        assertTrue(nodeService.isConnected(1, 3));
        assertFalse(nodeService.isConnected(1, 4));
    }
}

