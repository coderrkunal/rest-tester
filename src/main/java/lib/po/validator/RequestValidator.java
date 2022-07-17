package lib.po.validator;

import lib.restlib.RestRequestObj;

public class RequestValidator {
  public static void validateGetRestRequest(final RestRequestObj restRequestObj){
    objectNotNull(restRequestObj);
    stringNotEmpty(restRequestObj.getHost());
    stringNotEmpty(restRequestObj.getProtocol());
    stringNotEmpty(restRequestObj.getEndpoint());
  }

  public static void validateRequestParam(final RestRequestObj restRequestObj){
    objectNotNull(restRequestObj);
    objectNotNull(restRequestObj.getReqParam());
    restRequestObj.getReqParam().forEach((k,v) -> stringNotEmpty(v));
  }

  private static void objectNotNull(Object object){
    if (object == null) throw new IllegalArgumentException(object.getClass().getName() + " Object is NULL");
  }

  private static void stringNotEmpty(String string){
    if(string == null || string.trim().isEmpty()) throw new IllegalArgumentException("String " + string +  "IS NULL");
  }
}
