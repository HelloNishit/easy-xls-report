/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package com.cignexdatamatics.easyxls.exception;

/**
 * Exception class for report runtime exception
 * 
 * @author nishit.charania
 * 
 */
public class XLSReportRuntimeException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 8684321823799643449L;

	public XLSReportRuntimeException(final Throwable cause)
	{
		super(cause);
	}

	public XLSReportRuntimeException(final String message)
	{
		super(message);
	}

}
