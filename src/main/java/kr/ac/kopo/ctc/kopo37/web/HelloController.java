package kr.ac.kopo.ctc.kopo37.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.kopo37.domain.Hello;

@Controller
// http 신호를 받아서 해당 경로에 따라 할 행동 결정, mapping
@RequestMapping(value = "/hello")
public class HelloController {
	
	@RequestMapping(value="")
	public String hello(Model model) {
		//model을 통해서 key 값 세팅, 페이지에서 사용할 수 있다.
		model.addAttribute("name", "홍길동");
		return "hello";
	}

	@RequestMapping(value="/getParameter")
	public String getParameter(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value = "/requestParam")
	public String requestParam(Model model, @RequestParam(value="name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	// 경로상에 인자를 바로 넣는 경우
	@RequestMapping(value = "/pathVariable/{name}")
	public String requestVariable(Model model, @PathVariable(value="name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	// 일반적으로 사용하기 좋음
	@RequestMapping(value = "/modelAttribute")
	public String modelAttribute(Model model, @ModelAttribute Hello hello) {
		model.addAttribute("name", hello.getName());
		return "hello";
	}
	
	@RequestMapping(value = "/requestBody1")
	public String requestBody1(Model model, @RequestBody Map<String, Object> obj) {
		model.addAttribute("name", obj.get("name"));
		return "hello";
	}
	
	@RequestMapping(value = "/requestBody2")
	public String requestBody2(Model model, @RequestBody Hello hello) {
		model.addAttribute("name", hello.getName());
		return "hello";
	}
	
}
