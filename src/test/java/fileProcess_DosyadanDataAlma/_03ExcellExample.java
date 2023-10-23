package fileProcess_DosyadanDataAlma;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class _03ExcellExample {

    @Test
    public void createExcellFile() throws IOException {
        //xlsx icin XSSF.., xls icin HSSF...
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        Row row = sheet.createRow(0);
        for (int i = 0; i <10 ; i++) {
            row.createCell(i).setCellValue(i+1);
        }
        XSSFSheet sheet2 = workbook.createSheet("Sayfa2");
        for (int i = 0; i < 10; i++) {
            Row row1 = sheet2.createRow(i);
            row1.createCell(0).setCellValue(i+1);
        }
       /* XSSFSheet sheet3 = workbook.createSheet("Sayfa3");
        for (int i = 0; i < 10; i++) {
            Row row1 = sheet3.createRow(i);
            row1.createCell(i).setCellValue(i+1);
            for (int j = 0; j <i; j++) {

                row1.createCell(j).setCellValue(j+1);

            }*/
        //   1 den 100 kadar tablo seklinde yazdirma

            XSSFSheet sheet3 = workbook.createSheet("Sayfa3");

            for (int i = 0; i < 10; i++) {
                Row row2 = sheet3.createRow(i+1);

                for (int j = 0; j < 10; j++) {

                    row2.createCell(j).setCellValue(i*10+j+1);
                }

            }
            // carpim tablosu

        XSSFSheet sheet4 = workbook.createSheet("Sayfa4");

        for (int i = 0; i < 10; i++) {

            Row row3 = sheet4.createRow(i);
            row3.createCell(0).setCellValue(3);
            row3.createCell(1).setCellValue("x");
            row3.createCell(2).setCellValue(i+1);
            row3.createCell(3).setCellValue("=");
            row3.createCell(4).setCellValue(3*(i+1));
        }
        XSSFSheet sheet5 = workbook.createSheet("Sayfa5");

        for (int i = 11; i < 101 ; i=i+11) {
            for (int j = 0; j < 10; j++) {

                int carpim = j+1;
                int carpan = i/10;
                int sonuc = carpan*carpim;

                Row row3 = sheet5.createRow(j+i-11);
                row3.createCell(0).setCellValue(carpan);
                row3.createCell(1).setCellValue("x");
                row3.createCell(2).setCellValue(carpim);
                row3.createCell(3).setCellValue("=");
                row3.createCell(4).setCellValue(sonuc);
            }


        }



        /*int maxNumber = 3;

        for (int i = 1; i <= 10; i++) {
            Row row3 = sheet4.createRow(i-1);
            Cell cell = row3.createCell(2);
            cell.setCellValue(maxNumber + " x " + i  + " = " + (i * maxNumber));
        }
*/




        String file = "src/test/java/fileProcess_DosyadanDataAlma/MyExcell2.xlsx";
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }
    }

