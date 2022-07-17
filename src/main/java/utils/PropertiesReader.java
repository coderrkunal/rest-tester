package utils;

import java.io.File;

abstract class PropertiesReader {
  protected final File propsFile;

  public PropertiesReader(File appPropertyFile) {
    assert (appPropertyFile != null);
    this.propsFile = appPropertyFile;
  }

  public PropertiesReader(){this.propsFile = null;}

  public File getPropsFile(){return propsFile;}
}
