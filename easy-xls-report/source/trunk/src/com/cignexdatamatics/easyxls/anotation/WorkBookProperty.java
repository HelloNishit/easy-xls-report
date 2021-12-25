/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package com.cignexdatamatics.easyxls.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for Work Book property
 * 
 * @author nishit.charania
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WorkBookProperty
{

	/**
	 * property for work book name
	 * 
	 * @return
	 */
	String WorkBookName();
	
	Class customMethodClass() default Class.class ;
	
	/**
	 * 
	 * @return
	 */
	String customTitleMethod() default "" ;
}
