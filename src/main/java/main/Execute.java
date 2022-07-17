package main;

import utils.RestApiPropertiesReader;

import java.io.File;
import java.io.IOException;

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
    System.out.println("Starting to process");
  }
}
