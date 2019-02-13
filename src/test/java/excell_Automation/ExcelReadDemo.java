package excell_Automation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class ExcelReadDemo {


    @Test
    public void readExcelFile()throws Exception{
        // path to the excel document
        String path = "/Users/imran/Documents/Countries.xls";

        //Open file and covert to stream of data
        FileInputStream inputStream = new FileInputStream(path);
        //Workbook > worksheet > row > cell
        //Open the Workbook, Any type

        Workbook workbook = WorkbookFactory.create(inputStream);

        // Go to the first worksheet, index is 0
        Sheet worksheet = workbook.getSheetAt(0);

        // Go to the first row ,
        Row row = worksheet.getRow(0);

        //Go to first cell ,
        Cell cell1 = row.getCell(0);
        Cell cell2 = row.getCell(1);

        System.out.println(cell1.toString());
        System.out.println(cell2.toString());


        String country1 = worksheet.getRow(1).getCell(0).toString();
        String capital1 = workbook.getSheetAt(0).getRow(1).getCell(1).toString();

        System.out.println("Country 1: "+country1);
        System.out.println("Capital 1: "+capital1);

        String country2 = workbook.getSheetAt(0).getRow(2).getCell(0).toString();
        String capital2 = worksheet.getRow(2).getCell(1).toString();

        System.out.println("Country 2: "+country2);
        System.out.println("Capital 2: "+capital2);

        int rowsCount = worksheet.getLastRowNum();
        System.out.println("Total Row Number: "+rowsCount);
        System.out.println();
        for (int i = 1; i <= rowsCount ; i++) {
            System.out.println("Country: #"+i+": "+worksheet.getRow(i).getCell(0).toString()
            +" ===> " + "Capital: "+worksheet.getRow(i).getCell(1).toString());
        }

        // loop again and add country and capital city values into a Map
        Map<String,String> countriesMap = new HashMap<>();
        int countryCol = 0;
        int capitalCol = 1;
        for (int rowNum = 1; rowNum < rowsCount; rowNum++) {
            String country = worksheet
                            .getRow(rowNum)
                            .getCell(countryCol)
                            .toString();
            String capital = worksheet
                            .getRow(rowNum)
                            .getCell(capitalCol)
                            .toString();

            countriesMap.put(country,capital);

        }
        System.out.println(countriesMap);

        //Close workbook and stream

        workbook.close();
        inputStream.close();









    }
}
