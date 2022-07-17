package utils;

import lib.po.system.Constants;
import lib.po.system.RestProps;
import main.Execute;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static lib.po.system.Constants.RestPropsConstants.RESTPROPS_DEFAULT_RESTAPI_PROPERTY_FILE_NAME;

public class RestApiPropertiesReader extends PropertiesReader{
  Properties properties = new Properties();

  public RestApiPropertiesReader(File appPropertyFile) throws IOException {
    super(appPropertyFile);
    properties.load(new FileReader(propsFile));
  }

  public RestApiPropertiesReader() throws IOException {
    //Default constructor with default resource properties
    properties.load(Execute.class.getClassLoader().getResourceAsStream(RESTPROPS_DEFAULT_RESTAPI_PROPERTY_FILE_NAME));
  }

  public RestProps getRestProperties(){

    return new RestProps.RestPropsBuilder()
          .protocol(properties.getProperty("protocol", Constants.RestPropsConstants.RESTPROPS_DEFAULT_PROTOCOL))
          .host(properties.getProperty("host", Constants.RestPropsConstants.RESTPROPS_DEFAULT_HOST))
          .endpoint(properties.getProperty("endpoint", Constants.RestPropsConstants.RESTPROPS_DEFAULT_ENDPOINT))
          .urlParam(properties.getProperty("urlParam", Constants.RestPropsConstants.RESTPROPS_DEFAULT_URL_PARAM))
          .build();
  }
}
