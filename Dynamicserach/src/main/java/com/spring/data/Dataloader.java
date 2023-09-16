package com.spring.data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring.model.CitizenPlan;
import com.spring.repo.CitizenRepo;

@Component
public class Dataloader implements ApplicationRunner{

	@Autowired
	private CitizenRepo citizenrepo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		citizenrepo.deleteAll();
		CitizenPlan p1= new CitizenPlan("satish", "satish@gmail.com", 630022, 4548268,"Male", "Cash", "Approved", LocalDate.now(), LocalDate.now().plusMonths(6));
		CitizenPlan p2= new CitizenPlan("satya", "satya@gmail.com", 630090, 4548268,"Male", "Cash", "Denied", LocalDate.now(), LocalDate.now().plusMonths(6));
		CitizenPlan p3= new CitizenPlan("sangeetha", "sangeetha@gmail.com", 630022, 4548268,"Fe-Male", "Medical", "Approved", LocalDate.now(), LocalDate.now().plusMonths(6));
		CitizenPlan p4= new CitizenPlan("Naveen", "Naveen@gmail.com", 630035, 4548268,"Male", "Medical", "Denied", LocalDate.now(), LocalDate.now().plusMonths(6));
		CitizenPlan p5= new CitizenPlan("Abdul", "Abdul@gmail.com", 630067, 4548268,"Male", "Food", "Approved", LocalDate.now(), LocalDate.now().plusMonths(6));
		CitizenPlan p6= new CitizenPlan("Krishna", "Krishna@gmail.com", 6300334, 4548268,"Male", "Food", "Denied", LocalDate.now(), LocalDate.now().plusMonths(6));
         List<CitizenPlan> records = Arrays.asList(p1,p2,p3,p4,p5,p6);
         
		citizenrepo.saveAll(records);
	}
}
