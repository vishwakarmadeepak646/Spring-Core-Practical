package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.AttendanceDTO;
import com.rays.dto.AttendanceDTO;
import com.rays.form.AttendanceForm;
import com.rays.service.AttendanceService;

@RestController
@RequestMapping("attentdance")
public class AttendanceCtl extends BaseCtl{

	@Autowired
	AttendanceService service;
	
	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid AttendanceForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}
		
		AttendanceDTO dto = (AttendanceDTO) form.getDto();

		service.save(dto);

		res.addMessage("User saved successfully...");
		res.addData(dto);

		return res;
	}
	
	@PostMapping("update")
	public ORSResponse update(@RequestBody @Valid AttendanceForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		AttendanceDTO dto = (AttendanceDTO) form.getDto();

		service.save(dto);

		res.addMessage("User updated successfully...");
		res.addData(dto);
		res.setSuccess(true);

		return res;
	}

	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			service.delete(id);
			res.addMessage("user deleted successfully...");
			res.setSuccess(true);
		}
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		AttendanceDTO dto = service.findById(id);

		if (dto != null) {
			res.setSuccess(true);
			res.addData(dto);
		}

		return res;
	}

	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody AttendanceForm form, @PathVariable int pageNo) {
		ORSResponse res = new ORSResponse();
		AttendanceDTO dto = (AttendanceDTO) form.getDto();
		int pageSize = 5;
		List<AttendanceDTO> list = service.search(dto, pageNo, pageSize);
		if (list != null && list.size() > 0) {
			res.setSuccess(true);
			res.addData(list);
		} else {
			res.addMessage("record not found");
		}
		return res;
	}

}
