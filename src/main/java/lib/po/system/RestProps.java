package lib.po.system;

import java.util.Map;

public class RestProps {
  /*
    protocol: https
    host: api.ipify.org/
    endpoint: /
    url: format=json
   */

  private String protocol;
  private String host;
  private String endpoint;
  private String method;
  private Map<String, String> urlParamWithType;
  private Integer count;

  public Integer getCount() {
    return count;
  }

  public String getProtocol() {
    return protocol;
  }

  public String getHost() {
    return host;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getMethod(){
    return method;
  }

  public Map<String, String> getUrlParamWithType() {
    return urlParamWithType;
  }

  private RestProps(){

  }

  public static class RestPropsBuilder {
    private String protocol;

    public RestPropsBuilder protocol(String protocol){
      this.protocol = protocol; return this;
    }

    private String host;
    public RestPropsBuilder host(String host){
      this.host = host; return this;
    }

    private String endpoint;
    public RestPropsBuilder endpoint(String endpoint){
      this.endpoint = endpoint; return this;
    }

    private String method;
    public RestPropsBuilder method(String method){
      this.method = method; return this;
    }

    private Map<String, String> urlParam;
    public RestPropsBuilder urlParam(Map<String, String> urlParam){
      this.urlParam = urlParam; return this;
    }

    private Integer count;

    public RestPropsBuilder setCount(Integer count) {
      this.count = count; return this;
    }

    public RestProps build(){
      RestProps restProps = new RestProps();
      restProps.protocol = this.protocol;
      restProps.host = this.host;
      restProps.endpoint = this.endpoint;
      restProps.method = this.method;
      restProps.urlParamWithType = this.urlParam;
      restProps.count = this.count;
      return restProps;
    }
  }
}
