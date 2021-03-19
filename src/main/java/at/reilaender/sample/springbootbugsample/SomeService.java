package at.reilaender.sample.springbootbugsample;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeService {

  public static final String REST_PATH = "/some/url";

  private final RestTemplate restTemplate;

  public SomeService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  public void someRestTemplateCall() {
    restTemplate.getForObject(REST_PATH, String.class);
  }

  public String getRestPath() {
    return REST_PATH;
  }
}
