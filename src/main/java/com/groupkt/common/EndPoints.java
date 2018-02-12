package com.groupkt.common;

public class EndPoints {
	
      public static final String PATH_ALL_COUNTRY="/get/all";
      public static final String PATH_2CHAR_ISO="/get/iso2code/{alpha2_code}";
      public static final String  PATH_3CHAR_ISO="/get/iso3code/{alpha3_code}";
      public static final String PATH_ANYCHAR_ISO="/search";
      
      
      public static final String PATH_ALL_STATE="/get/{countryCode}/all";
      public static final String PATH_STATE_COUNTRY="/get/{countryCode}/{stateCode}";
      public static final String PATH_STATE_SEARCH_TEXT="/search/{countryCode}";
      
}
