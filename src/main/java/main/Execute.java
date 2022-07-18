package main;

import lib.po.system.RestProps;
import lib.restlib.RestRequestObj;
import lib.restlib.RestRequestObjGenerator;
import utils.RestApiPropertiesReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Execute {
  private final RestApiPropertiesReader propertiesReader;

  public Execute() throws IOException {
    propertiesReader = new RestApiPropertiesReader();
  }

  public Execute(String filePath) throws IOException {
    assert (filePath != null && !filePath.isEmpty());
    File file = new File(filePath);
    propertiesReader = new RestApiPropertiesReader(file);
  }

  public void process(){
    RestProps restProps = this.propertiesReader.getRestProperties();
    List<RestRequestObj> restRequestObjList = RestRequestObjGenerator.generate(restProps);
    System.out.println("Starting to process");
  }
}
