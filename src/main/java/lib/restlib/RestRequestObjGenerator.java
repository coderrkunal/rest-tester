package lib.restlib;

import lib.po.system.RestProps;
import lib.restlib.mixer.ParameterMixer;

import java.util.*;

public class RestRequestObjGenerator {
  public static List<RestRequestObj> generate(RestProps restProps){
    List<RestRequestObj> restRequestObjList = new ArrayList<>();
    boolean done = false;

    RestRequestObj.RestTemplateObjBuilder requestBuilder =
        new RestRequestObj.RestTemplateObjBuilder()
            .setHost(restProps.getHost())
            .setEndpoint(restProps.getEndpoint())
            .setMethod(restProps.getMethod())
            .setProtocol(restProps.getProtocol());

    ParameterMixer parameterMixer = new ParameterMixer(restProps.getUrlParamWithType());

    while(!done){
      //generate parameters
      requestBuilder.setReqParam(parameterMixer.generateUrlParamObject());

      //Add to request list
      restRequestObjList.add(requestBuilder.build());

      //Check if we are done with all possible generation
      //If so then mark done
      if(restProps.getCount().equals(restRequestObjList.size())){
        done = true;
      }
    }

    return restRequestObjList;
  }

  private List<String> generateStringRequestParam(String param, int maxCount){
    //TODO: implement
    return null;
  }

  private List<String> generateStringRequestParam(String param, List<String> possibleValues){
    List<String> valuesList = new ArrayList<>();
    return valuesList;
  }
}
