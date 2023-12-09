package com.app.mj;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin") // Optional
public class AdminRestController {
	@GetMapping("/show")
	public String helloMsgGet() {
		return "Hello From GET";
	}

	@GetMapping("/show/{sid}/{sname}/{sfee}")
	public String showMsg(@PathVariable int sid, @PathVariable String sname, @PathVariable double sfee) {
		return "Heloo :" + sid + "," + sname + "," + sfee;
	} //http://localhost:2019/myApp/admin/show/10/Uday/56.8
	
	

	@PostMapping("/show")
	public String helloMsgPost() {
		return "Hello From POST";
	}

	@PutMapping("/show")
	public String helloMsgPut() {
		return "Hello From PUT";
	}

	@DeleteMapping("/show")
	public String helloMsgDelete() {
		return "Hello From DELETE";
	}

	@PatchMapping("/show")
	public String helloMsgPatch() {
		return "Hello From PATCH";
	}

}