/**
 * 
 */
package com.ineatconseil.yougo.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ineatconseil.yougo.server.dto.EmployeeDTO;

/**
 * @author aelamrani
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	/**
	 * Allows to retrieve all the employees.
	 * @return a list of employees
	 */
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeDTO> getEmployees() {

		final List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		final EmployeeDTO employeeDTO1 = new EmployeeDTO();
		final EmployeeDTO employeeDTO2 = new EmployeeDTO();
		final EmployeeDTO employeeDTO3 = new EmployeeDTO();

		/** Employee 1 */
		employeeDTO1.setFirstName("Melton");
		employeeDTO1.setLastName("John");
		employeeDTOs.add(employeeDTO1);

		/** Employee 2 */
		employeeDTO2.setFirstName("Francis");
		employeeDTO2.setLastName("LaLine");
		employeeDTOs.add(employeeDTO2);

		/** Employee 3 */
		employeeDTO3.setFirstName("Pabeau");
		employeeDTO3.setLastName("Picasso");
		employeeDTOs.add(employeeDTO3);

		return employeeDTOs;

	}
}
