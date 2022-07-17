package lib.po.system;

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

  private String urlParam;

  public String getProtocol() {
    return protocol;
  }

  public String getHost() {
    return host;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getUrlParam() {
    return urlParam;
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

    private String urlParam;
    public RestPropsBuilder urlParam(String urlParam){
      this.urlParam = urlParam; return this;
    }

    public RestProps build(){
      RestProps restProps = new RestProps();
      restProps.protocol = this.protocol;
      restProps.host = this.host;
      restProps.endpoint = this.endpoint;
      restProps.urlParam = this.urlParam;
      return restProps;
    }
  }
}
