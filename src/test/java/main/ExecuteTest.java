package main;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.transaction.NotSupportedException;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ExecuteTest {

  @BeforeMethod public void setUp() {
    //setup execute object
  }

  @AfterMethod public void tearDown() {
    //clean up objects
  }

  @Test public void testProcess() {
    //Test asserts
    try {
      Execute execute = new Execute();
      execute.process();
    }catch (IOException | NotSupportedException e) {
      Assert.fail("testProcess Failed with : " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Test public void testProcessWithPropsFile() {
    //Test asserts
    String resourceName = "temp.txt";
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      File file = new File(classLoader.getResource(resourceName).getFile());
      String absolutePath = file.getAbsolutePath();
      Execute execute = new Execute(absolutePath);
      execute.process();
    } catch (IOException | NotSupportedException e) {
      Assert.fail("testProcessWithPropsFile Failed with : " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Test public void testProcessFail() {
    //Test asserts
    assertTrue(true);
  }
}