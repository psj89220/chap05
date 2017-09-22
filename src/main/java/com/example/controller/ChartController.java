package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.DeptVO;
import com.example.domain.EmpVO;
import com.example.repository.DeptRepository;

import be.ceau.chart.BarChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.options.BarOptions;
import be.ceau.chart.options.scales.BarScale;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/chart")
@Log
public class ChartController {
	
	@Inject
	DeptRepository deptRepository;
	
	@GetMapping("/bar")
	public String barChart(Model model) {
		log.info("/chart/bar barChart()...");
		
		List<DeptVO> depts = deptRepository.findAll();
		List<BarChart> bars = getChart(depts);
		
		model.addAttribute("depts", depts);
		model.addAttribute("bars", bars);
		return "jsp/chart/bar";
	}
	
	@GetMapping("/bar2")
	public String barChart2(Model model) {
		log.info("/chart/bar2 barChart2()...");
		
		List<DeptVO> depts = deptRepository.findAll();
		List<BarChart> bars = getChart(depts);
		
		model.addAttribute("depts", depts);
		model.addAttribute("bars", bars);
		return "thymeleaf/chart/bar";
	}
	
	@Transactional
	public List<BarChart> getChart(List<DeptVO> depts) {
		List<BarChart> bars = new ArrayList<>();

		// BarChart선언: root(BarData와 BarOptions를 포함)
		for(DeptVO dept : depts) {
			BarChart bar = new BarChart();
			
			BarData data = new BarData();
			BarOptions options = new BarOptions();

			bar.setData(data);
			bar.setOptions(options);
			
			BarScale scale = options.getScales();
			List<EmpVO> emps = dept.getEmps();

			BarDataset set1 = new BarDataset();
			for(EmpVO emp : emps) {
				set1.addData(emp.getSal());
				data.addLabel(emp.getEname());
			}
			
			set1.setLabel(dept.getDeptno() + " " + dept.getDname());
			set1.setBackgroundColor(Color.random());			
			data.addDataset(set1);
			
			bars.add(bar);
		}

//		bars.forEach(e -> System.out.println(e.toJson()));
		return bars;
	}
	
}
