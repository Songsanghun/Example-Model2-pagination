package util;

import javax.servlet.http.HttpServletRequest;

public class ParamMap {
	public static String getValues(HttpServletRequest request,String name){
		String rs= "";
		String[] values =(String[]) request.getParameterMap().get(name); 
/*		StringBuffer buff =new StringBuffer();*/
		
		for(String s : values){
			/*buff.append(s+",");*/
			rs+=s+",";
		}
		for(int i =0;i<values.length;i++){
			if(i==values.length){
				rs+=values[values.length];
			}else{
				rs+=values[i]+",";
			}
			rs+=values[i]+",";
		}
		/*System.out.println("버퍼에 담긴 내용 : "+buff);*/
		System.out.println("버퍼에 담긴 내용 : "+rs);
/*		rs=buff.toString().substring(0,1);*/
		rs=rs.substring(0,values.length-1);
		return rs;
	}
}
