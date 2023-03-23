package Com.NodeMaker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.NodeMaker.Model.NodeConnectionRequest;
import Com.NodeMaker.Service.NodeService;

@RestController
@RequestMapping("/api/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @PostMapping("/join")
    public ResponseEntity<String> joinNodes(@RequestBody NodeConnectionRequest request) {
        nodeService.joinNodes(request.getNode1(), request.getNode2());
        return ResponseEntity.ok().body("Successful..!").status(HttpStatus.CREATED).build();
        		
    }
    
    @GetMapping("/isConnected")
    public boolean isConnected(@RequestParam int node1, @RequestParam int node2) {
        return nodeService.isConnected(node1, node2);
    }
}

