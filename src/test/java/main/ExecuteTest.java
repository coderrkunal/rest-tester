package main;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    Execute execute = null;
    try {
      execute = new Execute();
      execute.process();
    }catch (IOException e) {
      Assert.fail("testProcess Failed with : " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Test public void testProcessWithPropsFile() {
    //Test asserts
    Execute execute = null;
    String resourceName = "temp.txt";
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      File file = new File(classLoader.getResource(resourceName).getFile());
      String absolutePath = file.getAbsolutePath();
      execute = new Execute(absolutePath);
    } catch (IOException e) {
      Assert.fail("testProcessWithPropsFile Failed with : " + e.getMessage());
      e.printStackTrace();
    }
    execute.process();
  }

  @Test public void testProcessFail() {
    //Test asserts
    assertTrue(true);
  }
}