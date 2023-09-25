package com.spring.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.email.EmailUtil;
import com.spring.model.CitizenPlan;
import com.spring.repo.CitizenRepo;
import com.spring.search.Searchentity;




@Service
public class CitizenServicImpl implements CitizenService{
	
	@Autowired
	private CitizenRepo citizenrepo;
	
	@Autowired
	private EmailUtil emailUtil;
	
	

	
	@Autowired
	public CitizenServicImpl(CitizenRepo citizenrepo, EmailUtil emailUtil) {
		super();
		this.citizenrepo = citizenrepo;
		this.emailUtil = emailUtil;
	}

	@Override
	public List<String> getPlan() {
		
		
		return citizenrepo.getUniquePlanNames();
	}

	@Override
	public List<String> getstatus() {
		
		return citizenrepo.getUniquePlanStatus();
	}

	public List<String> getGender(){
		return citizenrepo.getGender();
		
	}
	@Override
	public List<CitizenPlan> getSearchedrecorde(Searchentity search) {
		
		CitizenPlan entity = new CitizenPlan();
		
		
		if(StringUtils.isNotBlank(search.getPlanName())) {
			entity.setPlanName(search.getPlanName());
			
		}
		if(StringUtils.isNotBlank(search.getPlanStatus())) {
			entity.setPlanStatus(search.getPlanStatus());;
			
		}
		if(StringUtils.isNotBlank(search.getGender())) {
			entity.setGender(search.getGender());;
			
		}
		
		if(null!=search.getStartDate()) {
			entity.setStartDate(search.getStartDate());
		}
		
		if(null!=search.getEndDate()) {
			entity.setEndDate(search.getEndDate());
		}
		
		
		Example<CitizenPlan> of=Example.of(entity);
		
		return citizenrepo.findAll(of);
	}

	@Override
	public void saveExcel(HttpServletResponse response) throws IOException {
		List<CitizenPlan> users = citizenrepo.findAll(); // Fetch all users from the repository
		
		//File tempFile =File.createTempFile("citizens",".xlsx");

		// Create Excel workbook and sheet
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = (Sheet) workbook.createSheet("Citizen Report Excel");

		// Create header row
		Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
		String[] headers = {"Full Name", "Email", "Phone", "SSN", "Gender", "Plan Name", "Plan Status", "Start Date", "End Date"};
		for (int i = 0; i < headers.length; i++) {
		Cell cell = headerRow.createCell(i);
		cell.setCellValue(headers[i]);
		}

		// Populate data rows
		int rowNum = 1;
		for (CitizenPlan user : users) {
		Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowNum++);
		row.createCell(0).setCellValue(user.getFullname());
		row.createCell(1).setCellValue(user.getEmail());
		row.createCell(2).setCellValue(user.getPhno());
		row.createCell(3).setCellValue(user.getSSN());
		row.createCell(4).setCellValue(user.getGender());
		row.createCell(5).setCellValue(user.getPlanName());
		row.createCell(6).setCellValue(user.getPlanStatus());
		row.createCell(7).setCellValue(user.getStartDate().toString());
		row.createCell(8).setCellValue(user.getEndDate().toString());
		}

		// Set the response headers
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=CitizenReport.xlsx");

		// Write the Excel workbook to the response stream
		workbook.write(response.getOutputStream());
		
		File f = new File("CitizenReport.xlsx");
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		emailUtil.sendEmail(f);

		// Close the workbook
		workbook.close();
		// Send Excel file as an email attachment
		
		
		
	}
	
	
	@Override
	public void savepdf(HttpServletResponse response) throws DocumentException, IOException {
	    List<CitizenPlan> users = citizenrepo.findAll(); // Fetch users from the database

	    // Create a ByteArrayOutputStream to hold the PDF content
	    ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();

	    // Set response headers for PDF download
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=Citizen Report.pdf");

	    // Create a PDF document
	    Document document = new Document();

	    // Use OpenPDF's PdfWriter
	    PdfWriter.getInstance(document, pdfOutputStream);

	    document.open();

	    // Add content to the PDF
	    for (CitizenPlan user : users) {
	        document.add(new Paragraph("User ID: " + user.getCitizen_Id()));
	        document.add(new Paragraph("Full Name: " + user.getFullname()));
	        document.add(new Paragraph("Email: " + user.getEmail()));
	        document.add(new Paragraph("Plan Name: " + user.getPlanName()));
	        document.add(new Paragraph("Plan Status: " + user.getPlanStatus()));
	        document.add(new Paragraph("SSN : " + user.getSSN()));
	        document.add(new Paragraph("Gender: " + user.getGender()));
	        document.add(new Paragraph("start_date: " + user.getStartDate()));
	        document.add(new Paragraph("End_date: " + user.getEndDate()));

	        document.add(new Paragraph("\n")); // Add some spacing between users
	    }

	    document.close();

	    // Send the generated PDF as an email attachment
	    emailUtil.sendPdfAsEmailAttachment(pdfOutputStream.toByteArray());
	}

	
	
    
	
	
		
}
