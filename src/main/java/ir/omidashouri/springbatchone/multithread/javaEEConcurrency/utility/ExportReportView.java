package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.utility;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountTransactionEntity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class ExportReportView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      org.apache.poi.ss.usermodel.Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment;filename=\"bankAccountTransaction.xls\"");
        List<BankAccountTransactionEntity> bankAccountTransactionList =
                (List<BankAccountTransactionEntity>) model.get("bankAccountTransactionList");
        Sheet sheet = workbook.createSheet("Student Data");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Account Transaction ID");
        header.createCell(1).setCellValue("Account Number");
        header.createCell(2).setCellValue("Account AMOUNT");
        header.createCell(3).setCellValue("Account TX_DATE");
        header.createCell(4).setCellValue("Account TX_ID");

        int rowNum = 1;
        for (BankAccountTransactionEntity bankAccountTransaction : bankAccountTransactionList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(bankAccountTransaction.getId());
            row.createCell(1).setCellValue(bankAccountTransaction.getAccNumber());
            row.createCell(2).setCellValue(bankAccountTransaction.getAmount());
            row.createCell(3).setCellValue(bankAccountTransaction.getTxDate());
            row.createCell(4).setCellValue(bankAccountTransaction.getTxId());
        }
    }

}
