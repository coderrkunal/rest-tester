package utils;

import lib.po.system.RestProps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class RestApiPropertiesReaderTest {

  @Test public void testGetRestPropertiesWithDefaults() {
    RestApiPropertiesReader apiPropertiesReader = null;
    try {
      apiPropertiesReader = new RestApiPropertiesReader();
    } catch (IOException e) {
      Assert.fail("testGetRestPropertiesWithDefaults failed with : " + e.getMessage());
      e.printStackTrace();
    }
    RestProps restProps = apiPropertiesReader.getRestProperties();
    Assert.assertNotNull(restProps);
    Assert.assertNotNull(restProps.getProtocol());
    Assert.assertNotNull(restProps.getHost());
    Assert.assertNotNull(restProps.getEndpoint());
    Assert.assertNotNull(restProps.getUrlParam());
  }

  @Test public void testGetRestPropertiesWithProperties() {
    File file = new File("/Users/kunal/IdeaProjects/RestTester/src/test/java/utils/dummytest.properties");
    RestApiPropertiesReader apiPropertiesReader = null;
    try {
      apiPropertiesReader = new RestApiPropertiesReader(file);
    } catch (IOException e) {
      Assert.fail("testGetRestPropertiesWithProperties failed with: " + e.getMessage());
      e.printStackTrace();
    }
    RestProps restProps = apiPropertiesReader.getRestProperties();
    Assert.assertNotNull(restProps);
    Assert.assertNotNull(restProps.getProtocol());
    Assert.assertNotNull(restProps.getHost());
    Assert.assertNotNull(restProps.getEndpoint());
    Assert.assertNotNull(restProps.getUrlParam());
  }
}