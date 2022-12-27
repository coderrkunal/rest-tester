package lib.restlib.mixer;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.util.*;

public class ParameterMixer {
    EasyRandom easyRandom = new EasyRandom();
    EasyRandomParameters parameters = new EasyRandomParameters();

    HashMap<String, TypeAndValues> paramValues = new HashMap<>();

    public ParameterMixer(final Map<String, String> urlParamWithType) {
        parameters.setStringLengthRange(new EasyRandomParameters.Range<>(0, 200));
        parameters.setCharset(EasyRandomParameters.DEFAULT_CHARSET);
        urlParamWithType.forEach((k,v) -> paramValues.put(k, decodeParamDetails(v)));
    }

    public Map<String, String> generateUrlParamObject(){
        return null;
    }

    private TypeAndValues decodeParamDetails(final String typeStr) {
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


    private static class TypeAndValues {
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
