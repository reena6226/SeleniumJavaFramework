package util;


public class ExcelUtilDemo {

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        ExcelUtils excelUtils = new ExcelUtils(projectPath+"/Excel/Book1.xlsx","DataSheet");
        ExcelUtils.getRowCount();
        ExcelUtils.getCellData(0,0);
        ExcelUtils.getCellDataNumber();

    }
}
