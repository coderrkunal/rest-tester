package lib.restlib;

import lib.restlib.impl.RestGetImpl;
import lib.restlib.impl.RestPostImpl;

public interface RestCall {
  RestResponseObj doCallSuccess(RestRequestObj restRequestObj);
  RestResponseObj doCallFailure(RestRequestObj restRequestObj);

  static RestCall getInstance(final String method) throws NoSuchFieldError {
    switch (method){
      case "get" : return new RestGetImpl();
      case "post" : return new RestPostImpl();
      default: throw new NoSuchFieldError(method + " is not supported yet!");
    }
  }
}
