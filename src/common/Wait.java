package common;

import java.util.HashMap;

public class Wait {

	public static void run(HashMap<String, Object> params){
	    if(params.get("Seconds") != null){
	    	try {
				Thread.sleep(Integer.parseInt((String) params.get("Seconds")) * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }    
	  }

}
