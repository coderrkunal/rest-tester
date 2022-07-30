package lib.restlib;

import lib.po.system.RestProps;

import java.util.*;

public class RestRequestObjGenerator {
  public static List<RestRequestObj> generate(RestProps restProps){
    List<RestRequestObj> restRequestObjList = new ArrayList<>();
    boolean done = false;

    RestRequestObj.RestTemplateObjBuilder requestBuilder =
        new RestRequestObj.RestTemplateObjBuilder()
            .setHost(restProps.getHost())
            .setEndpoint(restProps.getEndpoint())
            .setProtocol(restProps.getProtocol());

    while(!done){
      //generate parameters

      //Add to request list
      restRequestObjList.add(requestBuilder.build());

      //Check if we are done with all possible generation
      //If so then mark done
      if(restProps.getCount().equals(restRequestObjList.size())){
        done = true;
      }
    }

    return restRequestObjList;
  }

  private List<String> generateStringRequestParam(String param, int maxCount){
    //TODO: implement
    return null;
  }

  private List<String> generateStringRequestParam(String param, List<String> possibleValues){
    List<String> valuesList = new ArrayList<>();
    return valuesList;
  }

  private TypeAndValues decodeParamDetails(final String typeStr){
    int breakIdx = typeStr.indexOf("(");
    String type = (breakIdx == -1) ? typeStr : typeStr.substring(0, breakIdx);

    if(!supportedTypes.containsKey(type.toLowerCase())){
      throw new UnsupportedOperationException("Unsupported param type: " + type);
    }

    TypeAndValues typeAndValues = supportedTypes.get(type.toLowerCase());

    if(breakIdx != -1){
      String valueStr = typeStr.substring(breakIdx + 1, typeStr.lastIndexOf(")"));
      Scanner scanner = new Scanner(valueStr);
      scanner.useDelimiter(",");
      while(scanner.hasNext()){
        typeAndValues.addValue(scanner.next());
      }
    }

    return typeAndValues;
  }

  private final HashMap<String, TypeAndValues> supportedTypes = new HashMap<String, TypeAndValues>() {{
    put("string", new TypeAndValues("string"));
    put("int", new TypeAndValues("int"));
    put("float", new TypeAndValues("float"));
    put("boolean", new TypeAndValues("boolean"));
  }};


  private static class TypeAndValues{
    final private String type;
    final private List<String> values;

    public TypeAndValues(String type) {
      this.type = type;
      values = new ArrayList<>();
    }

    public String getType() {
      return type;
    }

    public void addValue(String val){
      values.add(val);
    }

    public List<String> getValues() {
      return values;
    }
  }
}
