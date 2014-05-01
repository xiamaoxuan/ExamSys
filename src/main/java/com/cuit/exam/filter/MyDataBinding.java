package com.cuit.exam.filter;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * 
* @ClassName: DateConverter 
* @Description: 日期格式过滤 
* @author 夏 茂轩  
* @date 2014年3月2日 下午6:01:50 
*
 */
public class MyDataBinding implements WebBindingInitializer {
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.setLenient(false);

		SimpleDateFormat datetimeFormat = new SimpleDateFormat(
				"yyyy-mm-dd hh:mm");
		datetimeFormat.setLenient(false);

		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(java.sql.Timestamp.class,
				new CustomTimestampEditor(datetimeFormat, true));
	}
}