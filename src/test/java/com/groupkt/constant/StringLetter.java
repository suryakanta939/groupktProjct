package com.groupkt.constant;

import org.testng.annotations.Test;

public class StringLetter {
  @Test
  public void builtMethod() {
	  String word="hi how r u 1234";
	  String onlyLet="";
	  char[] let=word.toCharArray();
	  for(int i=0;i<let.length;i++){
		  if(Character.isDigit(let[i])==false){
			  onlyLet=let[i]+"";
		  }else{
			  continue;
		  }
		  System.out.print(onlyLet);
	  }
	 
  }
  @Test
  public void anothermethod() {
	  String word="hi123 how r u 1234";
	  String onlyLet="";
	  char[] let=word.toCharArray();
	  for(int i=0;i<let.length;i++){
		  try{
			  Integer.parseInt(let[i]+"");
			  continue;
		  }catch (Exception e) {
			  onlyLet=let[i]+"";
		}
		
		  System.out.print(onlyLet);
	  }
	  System.out.println("/t");
//	 int s=Integer.parseInt("13");
//	 System.out.println(s);
  }
}
