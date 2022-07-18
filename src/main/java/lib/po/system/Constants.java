package lib.po.system;

import java.util.HashMap;
import java.util.Map;

public interface Constants {
  interface GlobalConstants{
    String APP_PROPERTY_FILE_NAME = "app.properties";
  }

  interface RestPropsConstants{
    String RESTPROPS_DEFAULT_RESTAPI_PROPERTY_FILE_NAME = "default.properties";
    String RESTPROPS_DEFAULT_PROTOCOL = "https://";
    String RESTPROPS_DEFAULT_HOST = "";
    String RESTPROPS_DEFAULT_ENDPOINT = "/";
    String RESTPROPS_DEFAULT_COUNT = "10";
    Map<String, String> RESTPROPS_DEFAULT_URL_PARAM = new HashMap<>();
  }
}
