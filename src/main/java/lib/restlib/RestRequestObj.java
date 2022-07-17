package lib.restlib;

import java.util.Map;

public class RestRequestObj {
  private final String host;
  private final String protocol;
  private final String endpoint;
  private final Map<String, String> headers;
  private final Map<String, String> reqParam;
  private final String jsonBody;

  public RestRequestObj(String host, String protocol, String endpoint, Map<String, String> headers, Map<String, String> reqParam,
      String jsonBody) {
    this.host = host;
    this.protocol = protocol;
    this.endpoint = endpoint;
    this.headers = headers;
    this.reqParam = reqParam;
    this.jsonBody = jsonBody;
  }

  public String getHost() {
    return host;
  }

  public String getProtocol() {
    return protocol;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public Map<String, String> getReqParam() {
    return reqParam;
  }

  public String getJsonBody() {
    return jsonBody;
  }

  public String constructAndGetURI(){
    return this.protocol + "://" + this.host + "/" + this.endpoint;
  }

  public static class RestTemplateObjBuilder{
    private String host;
    private String protocol;
    private String endpoint;
    private Map<String, String> headers;
    private Map<String, String> reqParam;
    private String jsonBody;

    public RestTemplateObjBuilder setHost(String host) {
      this.host = host; return this;
    }

    public RestTemplateObjBuilder setProtocol(String protocol) {
      this.protocol = protocol; return this;
    }

    public RestTemplateObjBuilder setEndpoint(String endpoint) {
      this.endpoint = endpoint; return this;
    }

    public void setHeaders(Map<String, String> headers) {
      this.headers = headers;
    }

    public RestTemplateObjBuilder setReqParam(Map<String, String> reqParam) {
      this.reqParam = reqParam; return this;
    }

    public RestTemplateObjBuilder setJsonBody(String jsonBody) {
      this.jsonBody = jsonBody; return this;
    }

    public RestRequestObj build(){
      return new RestRequestObj(host, protocol, endpoint, headers, reqParam, jsonBody);
    }
  }
}
