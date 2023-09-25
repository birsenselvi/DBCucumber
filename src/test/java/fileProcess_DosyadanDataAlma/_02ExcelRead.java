package fileProcess_DosyadanDataAlma;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _02ExcelRead {
    @Test
    public void readExcelxls() throws IOException {

        String excelFile = "src/test/java/fileProcess/Excel1.xls";

        FileInputStream inputStream = new FileInputStream(excelFile);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet1 = workbook.getSheet("Sayfa");
        Row row = sheet1.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell.toString());
        inputStream.close();
    }
    @Test
    public void readExcelxlsx() throws IOException {

        String excelFile = "src/test/java/fileProcess/Users.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFile);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet1 = workbook.getSheetAt(0);
        Row row = sheet1.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell.toString());
        inputStream.close();
    }
    @Test
    public void readExcelxls1() throws IOException {

        String excelFile = "src/test/java/fileProcess/Users.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFile);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet1 = workbook.getSheet("data");
        int rowNum = sheet1.getPhysicalNumberOfRows();
        for (int i = 0; i < rowNum; i++) {
            Row row =sheet1.getRow(i);
            int cols = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cols; j++) {
                System.out.println(row.getCell(j)+"\t");

            }
            System.out.println();

        }
        inputStream.close();
    }
    @Test
    public void getDataFromExcell() throws IOException{
        String path = "src/test/java/fileProcess/Users.xlsx";
        for (List<String> row : getData(path)) {
            for (String cell : row) {
                System.out.print(cell + " \t");

            }
            System.out.println();
        }

    }
    public List<List<String>> getData(String path) throws IOException{
        List<List<String>> datas = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int rowNum = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowNum; i++) {
            List<String> rowdata = new ArrayList<>();
            Row row = sheet.getRow(i);
            int cols = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                rowdata.add(cell.toString());
            }
            datas.add(rowdata);
        }

        return datas;
    }
    @Test
    public void testWriteToExcell() throws IOException {

        String excelFile = "src/test/java/fileProcess/Excel.xls";
        String excelFile1 = "src/test/java/fileProcess/Excel.xls";

        FileInputStream inputStream = new FileInputStream(excelFile);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet1 = workbook.getSheetAt(0);
        int rowNum = sheet1.getPhysicalNumberOfRows();
        Row row = sheet1.createRow(rowNum);
        Cell cell0 = row.getCell(0);
        cell0.setCellValue(101);

        inputStream.close();// close() ederiz. islem ramde kalir ve asagida devam ederiz.

        FileOutputStream outputStream = new FileOutputStream(excelFile1); // dosyaya yeni veri ekleyince speichen a tiklar.
        workbook.write(outputStream);
        outputStream.close();
    }
    public List<List<String>> getData(String path, String sheetName, int startRow, int startCell) throws IOException{
        List<List<String>> datas = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowNum = sheet.getPhysicalNumberOfRows();

        for (int i = startRow; i < rowNum; i++) {
            List<String> rowdata = new ArrayList<>();
            Row row = sheet.getRow(i);
            int cols = row.getPhysicalNumberOfCells();
            for (int j = startCell; j < cols; j++) {
                Cell cell = row.getCell(j);
                rowdata.add(cell.toString());
            }
            datas.add(rowdata);
        }

        return datas;
    }
   @Test
    public void getDataFromExcell1() throws IOException{
        String file = "src/test/java/fileProcess_DosyadanDataAlma/Users.xlsx";
        List<List<String>> data = getData(file, "data",1, 3);
        for (List<String> row : data) {
            for (String cell : row) {
                System.out.printf("-10s \t" , cell);
            }
            System.out.println();
        }
    }
    @Test
    public void createExcellFile() throws IOException{
        //xlsx icin XSSF.., xls icin HSSF...
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(10);
        row.createCell(1).setCellValue(20);
        String file = "src/test/java/fileProcess_DosyadanDataAlma/MyExcell.xlsx";
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();

    }

}
