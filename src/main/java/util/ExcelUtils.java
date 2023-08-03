package util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


    public static  String Path;
   public static XSSFWorkbook workbook;
   public static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName){
     try {
         workbook = new XSSFWorkbook(excelPath);
         sheet = workbook.getSheet(sheetName);
    }catch(Exception e){
          e.printStackTrace();
     }


    }


    public static void main(String[] args) {
        getRowCount();
        getCellData(0,0);
        getCellDataNumber();
    }
    public static int getRowCount(){
      int rowCount = 0;
        try {

            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("no of row count"+ rowCount);

        }
        catch(Exception exp){
            String message = exp.getMessage();
            System.out.println("Message"+message);

        }

        return rowCount;
    }

    public static int getColumnCount(){
        int columnCount = 0;
        try {

            columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("no of row count"+ columnCount);

        }
        catch(Exception exp){
            String message = exp.getMessage();
            System.out.println("Message"+message);

        }
      return columnCount;
    }

    //get cell data

    public static String getCellData(int rowNum, int columnNum){
        String cellData = null;
        try {

           cellData =  sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();

          System.out.println("Cell data"+cellData);

        }
        catch(Exception exp){
            String message = exp.getMessage();
            System.out.println("Message"+message);

        }

        return cellData;
    }

    // get cell data number

    public static void getCellDataNumber(){

        try {

            double cellData =  sheet.getRow(1).getCell(1).getNumericCellValue();

            System.out.println("Cell data"+cellData);

        }
        catch(Exception exp){
            String message = exp.getMessage();
            System.out.println("Message"+message);

        }

    }
}
