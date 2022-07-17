package lib.po.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "TestResult")
public class TestResult {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  public String getRequestTemplate() {
    return requestTemplate;
  }

  public void setRequestTemplate(String requestTemplate) {
    this.requestTemplate = requestTemplate;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public Long getTimeToTest() {
    return timeToTest;
  }

  public void setTimeToTest(Long timeToTest) {
    this.timeToTest = timeToTest;
  }

  public String getResultState() {
    return resultState;
  }

  public void setResultState(String resultState) {
    this.resultState = resultState;
  }

  public Long getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(Long createdAt) {
    this.startedAt = createdAt;
  }

  public Long getEndedAt() {
    return endedAt;
  }

  public void setEndedAt(Long updatedAt) {
    this.endedAt = updatedAt;
  }

  private String requestTemplate;
  private String response;
  private Long timeToTest;
  private String resultState;
  private Long startedAt;
  private Long endedAt;

  @Override
  public String toString(){
    return id + " -- " + requestTemplate + " -- " + response
        + " -- " + timeToTest + " -- " + resultState
        + " -- " + startedAt + " -- " + endedAt;
  }
}
