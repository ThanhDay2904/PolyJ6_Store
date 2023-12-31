package poly.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/security/login/form")
	public String loginForm(Model m) {
		m.addAttribute("message", "Vui long dang nhap");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model m) {
		m.addAttribute("message", "Dang nhap thanh cong");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model m) {
		m.addAttribute("message", "Sai thong tin dang nhap");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model m) {
		m.addAttribute("message", "Khong co quyen truy xuat");
		return "security/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model m) {
		m.addAttribute("message", "Ban da dang xuat");
		return "security/login";
	}
}
