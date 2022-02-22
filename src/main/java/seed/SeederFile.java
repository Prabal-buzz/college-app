package seed;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.college.model.AdmissionFee;
import com.college.model.Program;
import com.college.model.Role;
import com.college.model.SecurityFee;
import com.college.repository.ProgramRepository;
import com.college.repository.RoleRepository;
import com.college.service.ProgramService;

@Controller
public class SeederFile  {
	
	  private	long millis=System.currentTimeMillis();  
	  private   Date date=new Date(millis); 
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private RoleRepository roleRepository;

	

	public void loadProgramData() {
		Role role=new Role();
		role.setName("Admin");
		roleRepository.save(role);
	}

}
