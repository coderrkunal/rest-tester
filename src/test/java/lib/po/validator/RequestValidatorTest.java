package lib.po.validator;

import lib.restlib.RestRequestObj;
import org.testng.annotations.Test;

public class RequestValidatorTest {
  @Test
  public void testValidateRestRequest(){
    RestRequestObj restRequestObj = new RestRequestObj.RestTemplateObjBuilder().build();
//     RequestValidator.validateGetRestRequest(restRequestObj);
  }

  @Test
  public void testValidateRequestParam(){
    RestRequestObj restRequestObj = new RestRequestObj.RestTemplateObjBuilder().build();
//     RequestValidator.validateRequestParam(restRequestObj);
  }
}
