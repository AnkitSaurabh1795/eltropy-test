package com.eltropy.test.bankingsystem.service;

import java.util.List;

import com.eltropy.test.bankingsystem.pojo.PdfGeneratorDetails;
import com.eltropy.test.bankingsystem.repo.Transaction;

public interface PdfGeneratorService {
	public List<Transaction> listTransactions(PdfGeneratorDetails pdfGeneratorDetails );
}
