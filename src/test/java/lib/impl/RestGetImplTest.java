package lib.impl;

import lib.restlib.RestResponseObj;
import lib.restlib.RestRequestObj;
import lib.restlib.impl.RestGetImpl;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestGetImplTest {
  @Test
  public void testCallGetSuccess(){
    RestRequestObj restRequestObj =
        new RestRequestObj.RestTemplateObjBuilder()
            .setProtocol("https")
            .setHost("httpbin.org")
            .setEndpoint("get")
            .build();
    RestResponseObj restResponseObj = new RestGetImpl().doCallSuccess(restRequestObj);
    Assert.assertNotNull(restResponseObj);

    // Get HttpResponse Status
    //    System.out.println(response.getProtocolVersion());              // HTTP/1.1
    StatusLine statusLine = restResponseObj.getStatusLine();
    Assert.assertNotNull(statusLine);
    Assert.assertEquals(statusLine.getStatusCode(), HttpStatus.SC_OK);
    System.out.println(statusLine.getStatusCode());   // 200
    Assert.assertEquals(statusLine.getReasonPhrase(), "OK");
    System.out.println(statusLine.getReasonPhrase()); // OK

    System.out.println(statusLine);        // HTTP/1.1 200 OK

    String entity = restResponseObj.getRespEntity();
    Assert.assertNotNull(entity);
    System.out.println(entity);
  }
}
