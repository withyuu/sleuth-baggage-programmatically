package withyuu.tutorial.a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/a")
public class AController {

  private static Logger log = LoggerFactory.getLogger(AController.class);

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/message")
  public String message(
      @RequestHeader(value = "Correlation-Id", required = false) String correlationId) {
    log.info("Service-A is called with Correlation-Id: {}", correlationId);
    String bMsg = restTemplate.getForObject("http://localhost:8081/b/message", String.class);
    return "Message from B: " + bMsg;
  }

}
