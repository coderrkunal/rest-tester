package lib.restlib.impl;

import lib.restlib.RestResponseObj;
import lib.restlib.RestCall;
import lib.restlib.RestRequestObj;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class RestGetImpl implements RestCall {
  @Override
  public RestResponseObj doCallSuccess(RestRequestObj restRequestObj) {
    RestResponseObj restResponseObj = null;
    try {
      restResponseObj = this.callGet(restRequestObj);
    } catch (IOException ioe){
      //TODO
    }
    return restResponseObj;
  }

  @Override public RestResponseObj doCallFailure(RestRequestObj restRequestObj) {
    RestResponseObj restResponseObj = null;
    try {
      restResponseObj = this.callGet(restRequestObj);
    } catch (IOException ioe){
      //TODO
    }

    return restResponseObj;
  }

  private RestResponseObj callGet(final RestRequestObj restRequestObj) throws IOException {
    System.out.println("RequestObj: " + restRequestObj);
    RestResponseObj restResponseObj;
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet request = new HttpGet(restRequestObj.constructAndGetURI());
      // add request headers

      // add url params
      if(restRequestObj.getReqParam() != null) {
        URIBuilder uriBuilder = new URIBuilder(request.getURI());
        restRequestObj.getReqParam().forEach(uriBuilder::addParameter);
        request.setURI(uriBuilder.build());
      }

      RestResponseObj.ResponseObjBuilder responseObjBuilder = new RestResponseObj.ResponseObjBuilder();
      responseObjBuilder.setStartTime(System.nanoTime());
      try (CloseableHttpResponse response = httpClient.execute(request)) {
        responseObjBuilder.setEndTime(System.nanoTime());
        restResponseObj = responseObjBuilder.setStatusLine(response.getStatusLine())
            .setRespEntity(EntityUtils.toString(response.getEntity()))
            .build();
      }
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
    System.out.println("ResponseObj: " + restResponseObj);
    return restResponseObj;
  }
}
