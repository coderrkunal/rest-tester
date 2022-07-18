package lib.restlib;

import lib.po.system.RestProps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestRequestObjGenerator {
  public static List<RestRequestObj> generate(RestProps restProps){
    List<RestRequestObj> restRequestObjList = new ArrayList<>();
    boolean done = false;

    RestRequestObj.RestTemplateObjBuilder requestBuilder =
        new RestRequestObj.RestTemplateObjBuilder()
            .setHost(restProps.getHost())
            .setEndpoint(restProps.getEndpoint())
            .setProtocol(restProps.getProtocol());

    while(!done){
      restRequestObjList.add(requestBuilder.build());
      if(restProps.getCount().equals(restRequestObjList.size())){
        done = true;
      }
    }

    return restRequestObjList;
  }

  private List<String> generateStringRequestParam(String param){
    //TODO: implement
    return null;
  }

  private String decodeParamType(){
    //TODO: implement
    return null;
  }
}
