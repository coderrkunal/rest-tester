package lib.po.db.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lib.po.db.entity.ResultState;
import lib.po.db.entity.TestResult;
import lib.restlib.RestRequestObj;
import lib.restlib.RestResponseObj;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TestResultOperation {
  public static void createRecord(final RestRequestObj restRequestObj, final RestResponseObj responseObj
      , final ResultState resultState){
    TestResult testResult = new TestResult();
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    try {
      testResult.setRequestTemplate(ow.writeValueAsString(restRequestObj));
      testResult.setResponse(ow.writeValueAsString(responseObj));

      testResult.setStartedAt(responseObj.getStartTime());
      testResult.setEndedAt(responseObj.getEndTime());

      testResult.setResultState(resultState.toString());
    }catch (JsonProcessingException jpe){
      //TODO
      testResult = null;
    }
    //Save in the end only if not null
    if(testResult != null) save(testResult);
  }

  private static void save(TestResult testResult){
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      // start a transaction
      transaction = session.beginTransaction();
      // save the student objects
      session.save(testResult);
      // commit transaction
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }

  public static List<TestResult> getAllTestResults(){
    List<TestResult> results = new ArrayList<>();
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      results = session.createQuery("from TestResult", TestResult.class).list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return results;
  }
}
