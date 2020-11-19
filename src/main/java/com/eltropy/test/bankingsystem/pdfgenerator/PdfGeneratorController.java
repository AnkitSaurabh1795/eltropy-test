package com.eltropy.test.bankingsystem.pdfgenerator;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eltropy.test.bankingsystem.pojo.PdfGeneratorDetails;
import com.eltropy.test.bankingsystem.repo.Transaction;
import com.eltropy.test.bankingsystem.service.PdfGeneratorService;
import com.eltropy.test.bankingsystem.utility.GeneratePdfReport;
import com.itextpdf.text.DocumentException;
@RestController
public class PdfGeneratorController {
	@Autowired
	private PdfGeneratorService pdfGeneratorService;
	@PostMapping("/generatePdf")
	public void generatePdf(HttpServletResponse response,@RequestBody PdfGeneratorDetails pdfGeneratorDetails)throws DocumentException, IOException {
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Transaction> listTransactions = pdfGeneratorService.listTransactions(pdfGeneratorDetails);
        System.out.println("check1"+listTransactions.size());
        GeneratePdfReport generator = new GeneratePdfReport(listTransactions);
        generator.export(response);
	}
}
