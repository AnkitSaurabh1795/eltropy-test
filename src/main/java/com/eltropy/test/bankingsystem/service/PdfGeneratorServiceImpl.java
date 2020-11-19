package com.eltropy.test.bankingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltropy.test.bankingsystem.pojo.PdfGeneratorDetails;
import com.eltropy.test.bankingsystem.repo.Transaction;
import com.eltropy.test.bankingsystem.repo.TransactionRepository;
@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService{
	@Autowired
	private TransactionRepository transactionRepository;
	public List<Transaction> listTransactions(PdfGeneratorDetails pdfGeneratorDetails){
		return transactionRepository.findByFromaccountOrToaccountAndDate(pdfGeneratorDetails.getAccountno(),pdfGeneratorDetails.getAccountno(), pdfGeneratorDetails.getFromdate(), pdfGeneratorDetails.getTodate());
	}
    


}
