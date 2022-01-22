package com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.dao.PurchaseReportDao;
import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.model.PurchaseReport;

@Controller
public class PurchaseReportController {

	@Autowired
	PurchaseReportDao purchaseReportDao;
	
	@GetMapping("/purchaseReportList")
	public String showListOfReports(Model model) {
		
		List<PurchaseReport> reports =  purchaseReportDao.getPurchaseReportList();
		System.out.print(reports);
		model.addAttribute("reports",reports);
		return "purchaseReportList";
	}
	
	@GetMapping("/ascending")
	public String showListOfReportsInAscendingOrder(Model model) {
		
		List<PurchaseReport> reports =  purchaseReportDao.getReportByOrder("ascending");
		System.out.print(reports);
		model.addAttribute("reports",reports);
		return "purchaseReportList";
	}
	
	@GetMapping("/descending")
	public String showListOfReportsInDescendingOrder(Model model) {
		
		List<PurchaseReport> reports =  purchaseReportDao.getReportByOrder("descending");
		System.out.print(reports);
		model.addAttribute("reports",reports);
		return "purchaseReportList";
	}
	
	
}
