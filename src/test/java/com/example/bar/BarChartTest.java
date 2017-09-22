package com.example.bar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.DeptVO;
import com.example.domain.EmpVO;
import com.example.repository.DeptRepository;
import com.example.util.Opener;
import be.ceau.chart.BarChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.options.BarOptions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BarChartTest {
	
	@Inject
	DeptRepository deptRepository;

	
	@Test
	@Transactional
	public void testFindAll() throws IOException {
		deptRepository.findAll().forEach(e -> {
			System.out.println(e);
			System.out.println(e.getEmps());
		});
	}
	
	@Test
	public void test() throws IOException {
		// BarChart선언: root(BarData와 BarOptions를 포함)
		BarChart bar = new BarChart();
		
		BarData data = new BarData();
		BarOptions options = new BarOptions();
		
		bar.setData(data);
		bar.setOptions(options);
		
		// Data Setting
		BarDataset set1 = new BarDataset();
		set1.setData(1200, 1500, 1700, 1550, 1440);
		set1.setLabel("1988");
		set1.setBackgroundColor(Color.RED);
		
		BarDataset set2 = new BarDataset();
		set2.setData(550, 1500, 900, 450, 340);
		set2.setLabel("1989");
		set2.setBackgroundColor(Color.BLUE);
		
		// Data입력예시(월별 지연건수)
		data.addDataset(set1);
		data.addDataset(set2);
		data.setLabels("Jan", "Feb", "Mar", "Apr", "May");
//		, "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");		
		Opener.inBrowser(bar);
	}
	
	@Test
	@Transactional
	public void test2() throws IOException {
		List<BarChart> bars = new ArrayList<>();
		List<DeptVO> depts = deptRepository.findAll();
//		DeptVO vo10 = deptRepository.findById(30).get();
		// BarChart선언: root(BarData와 BarOptions를 포함)
		for(DeptVO dept : depts) {
			BarChart bar = new BarChart();
			
			BarData data = new BarData();
			BarOptions options = new BarOptions();
					
			bar.setData(data);
			bar.setOptions(options);
			List<EmpVO> emps = dept.getEmps();
//			vo.getEmps()
			BarDataset set1 = new BarDataset();
//			set1.setData(800, 1500, 1700, 1550);
			for(EmpVO emp : emps) {
				set1.addData(emp.getSal());
				data.addLabel(emp.getEname());
			}
			
			set1.setLabel(dept.getDeptno() + " " + dept.getDname());
			set1.setBackgroundColor(Color.random());
			data.addDataset(set1);
			
			bars.add(bar);
		}

		bars.forEach(e -> {
			System.out.println(e.toJson());
		});
//		System.out.println(bar.toJson());
//		Opener.inBrowser(bar);
	}
}
