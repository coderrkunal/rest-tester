package lib.restlib;

public interface RestCall {
  RestResponseObj doCallSuccess(RestRequestObj restRequestObj);
  RestResponseObj doCallFailure(RestRequestObj restRequestObj);
}
