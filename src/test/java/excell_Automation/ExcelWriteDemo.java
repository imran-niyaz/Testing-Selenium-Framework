package excell_Automation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWriteDemo {


    @Test
    public void writeDemo() throws Exception{
        String filePath = "./src/test/resources/Countries.xls";


        FileInputStream in = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(in);
        Sheet worksheet = workbook.getSheetAt(0);

        // Write column name

        Cell column = worksheet.getRow(0).getCell(2);
        if(column == null){
            column = worksheet.getRow(0).createCell(2);
        }
        column.setCellValue("continent");


        Cell continent1 = worksheet.getRow(1).getCell(2);
        if(continent1 == null){
            continent1 = worksheet.getRow(1).createCell(2);
        }
        continent1.setCellValue("North America");

        //Save Changes
        // Open the file to write into it
        FileOutputStream out = new FileOutputStream(filePath);
        //Write and save the changes
        workbook.write(out);

        out.close();
        workbook.close();
        in.close();


    }

}
