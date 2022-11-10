package lib.restlib;

import lombok.ToString;
import org.apache.http.Header;
import org.apache.http.StatusLine;

import java.util.List;

@ToString
public class RestResponseObj {
  private final StatusLine statusLine;
  private final List<Header> respHeaders;
  private final String respEntity;

  public Long getStartTime() {
    return startTime;
  }

  public Long getEndTime() {
    return endTime;
  }

  private final Long startTime;
  private final Long endTime;

  public StatusLine getStatusLine() {
    return statusLine;
  }

  public List<Header> getRespHeaders() {
    return respHeaders;
  }

  public String getRespEntity() {
    return respEntity;
  }

  public RestResponseObj(StatusLine statusLine, List<Header> respHeaders, String respEntity, Long startTime,
      Long endTime) {
    this.statusLine = statusLine;
    this.respHeaders = respHeaders;
    this.respEntity = respEntity;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public static class ResponseObjBuilder{
    private StatusLine statusLine;
    private List<Header> respHeaders;
    private String respEntity;
    private Long startTime;
    private Long endTime;

    public ResponseObjBuilder setStatusLine(StatusLine statusLine) {
      this.statusLine = statusLine; return this;
    }

    public ResponseObjBuilder setRespHeaders(List<Header> respHeaders) {
      this.respHeaders = respHeaders; return this;
    }

    public ResponseObjBuilder setRespEntity(String respEntity) {
      this.respEntity = respEntity; return this;
    }

    public ResponseObjBuilder setStartTime(Long startTime) {
      this.startTime = startTime; return this;
    }

    public ResponseObjBuilder setEndTime(Long endTime) {
      this.endTime = endTime; return this;
    }

    public RestResponseObj build(){
      return new RestResponseObj(this.statusLine, this.respHeaders, this.respEntity, startTime, endTime);
    }
  }
}
