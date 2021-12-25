package easyxls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;


import com.cignexdatamatics.easyxls.util.ReportUtility;

public class ReportTest
{

	@Test
	public void testReport()
	{
		GenerateReport generateReport = new GenerateReport();
		File file = new File("test_report.xls");
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);
			ReportUtility.getHSSFWorkbook(fos, generateReport);			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null != fos)
			{
				try
				{
					fos.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
