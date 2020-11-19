package com.eltropy.test.bankingsystem.utility;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.eltropy.test.bankingsystem.repo.Transaction;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfReport {
	private List<Transaction> listTransactions;
    
    public GeneratePdfReport(List<Transaction> listTransactions) {
        this.listTransactions = listTransactions;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        cell.setPhrase(new Phrase("Date", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Transaction-Id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("From Account", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("To Account", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Amount", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Balance", font));
        table.addCell(cell);
    }
     
    private void writeTableData(PdfPTable table) {
        for (Transaction transaction : listTransactions) {
            table.addCell(transaction.getDate());
            table.addCell(transaction.getTransactionid().toString());
            table.addCell(transaction.getFromaccount().toString());
            table.addCell(transaction.getToaccount().toString());
            table.addCell(String.valueOf(transaction.getAmount()));
            table.addCell(String.valueOf(transaction.getBalance()));
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.BLUE);
         
        Paragraph p = new Paragraph("Account Statement", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.5f, 2.5f, 2.5f, 2.5f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
