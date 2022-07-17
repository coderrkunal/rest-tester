package utils;

import lib.po.system.Constants;
import lib.po.system.RestProps;
import main.Execute;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

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
    /*
     * List of url param in form of comma separated as key1:String, key2:Array[String], key3:Integer
     */
    String urlParamList = properties.getProperty("urlParam");
    Map<String, String> urlParamMap = new HashMap<>();
    if(urlParamList != null){
      Scanner scanner = new Scanner(urlParamList);
      scanner.useDelimiter(",");
      while(scanner.hasNext()){
        String param = scanner.next();
        int idx = param.indexOf(":");
        urlParamMap.put(param.substring(0, idx), param.substring(idx+1));
      }
    }

    return new RestProps.RestPropsBuilder()
          .protocol(properties.getProperty("protocol", Constants.RestPropsConstants.RESTPROPS_DEFAULT_PROTOCOL))
          .host(properties.getProperty("host", Constants.RestPropsConstants.RESTPROPS_DEFAULT_HOST))
          .endpoint(properties.getProperty("endpoint", Constants.RestPropsConstants.RESTPROPS_DEFAULT_ENDPOINT))
          .urlParam(urlParamMap)
          .build();
  }
}
