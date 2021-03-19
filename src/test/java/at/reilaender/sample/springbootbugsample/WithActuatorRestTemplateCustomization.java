package at.reilaender.sample.springbootbugsample;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestToUriTemplate;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.MockServerRestTemplateCustomizer;
import org.springframework.test.web.client.ExpectedCount;

@SpringBootTest
@AutoConfigureMockRestServiceServer
class WithActuatorRestTemplateCustomization {

  @Autowired
  MockServerRestTemplateCustomizer mockServerRestTemplateCustomizer;

  @Autowired
  SomeService someService;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void shouldFail() throws JsonProcessingException {
    mockServerRestTemplateCustomizer.getServer()
        .expect(ExpectedCount.times(1),
            requestToUriTemplate(someService.getRestPath()))
        .andRespond(withSuccess());

    someService.someRestTemplateCall();
  }

}
