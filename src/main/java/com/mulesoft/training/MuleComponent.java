package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

public class MuleComponent {

	int count;
	
	public MuleComponent(){
		count = 0;
	}
  public Map<String,String> processMap(Map<String, String> input) {
	  input.put("executed by", "processMap");
    return input;
  }

  public Map<String,String> processArray(List<String> input) {
	  Map<String, String> out = new HashMap<String, String>();
	  out.put("message", input.get(0));
	  out.put("executed by",  "processArray");
	  return out;
  }

  public Map<String,String> processString(String input) {
	  Map<String, String> out = new HashMap<String, String>();
	  out.put("message", input);
	  out.put("executed by",  "processString");
	  return out;
  }

  
  public Map<String,String> processAll(@Payload Object input, @InboundHeaders("http.method") String myHttpMethod) {
	  Map<String, String> out = new HashMap<String, String>();
	  out.put("message", input.toString());
	  out.put("http method used", myHttpMethod);
	  out.put("executed by",  "processAll");
	  out.put("count", String.valueOf(++count));
	  return out;
  }

} 
