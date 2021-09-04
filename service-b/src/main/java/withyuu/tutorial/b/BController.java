package withyuu.tutorial.b;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class BController {

  private static Logger log = LoggerFactory.getLogger(BController.class);

  @GetMapping("/message")
  public String message(
      @RequestHeader(value = "Correlation-Id", required = false) String correlationId) {
    log.info("Service-B is called with Correlation-Id: {}", correlationId);
    return "Greetings from Service-B!";
  }

}
