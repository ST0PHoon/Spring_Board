package kr.ac.kopo.ctc.kopo37.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.kopo37.domain.Hello;

@RestController
@RequestMapping(value = "/rest")
public class HelloRestController {

	@RequestMapping(value = "hello1")
	public ResponseEntity<Hello> hello1() {
		Hello hello = new Hello();
		hello.setId(1);
		hello.setName("abcd");
		return ResponseEntity.ok(hello);
	}
	
	@RequestMapping(value = "/hellos1")
	public ResponseEntity<List<Hello>> hellos1() {
		Hello hello1 = new Hello();
		hello1.setId(1);
		hello1.setName("abcd1");
		
		Hello hello2 = new Hello();
		hello2.setId(2);
		hello2.setName("abcd2");
		
		List<Hello> hellos = new ArrayList<Hello>();
		
		return ResponseEntity.ok(hellos);
	}
	
	@RequestMapping(value = "hello2")
	public Hello hello2() {
		Hello hello = new Hello();
		hello.setId(1);
		hello.setName("abcd");
		return hello;
	}
	
	@RequestMapping(value = "/hellos2")
	public List<Hello> hellos2() {
		Hello hello1 = new Hello();
		hello1.setId(1);
		hello1.setName("abcd1");
		
		Hello hello2 = new Hello();
		hello2.setId(2);
		hello2.setName("abcd2");
		
		List<Hello> hellos = new ArrayList<Hello>();
		hellos.add(hello1);
		hellos.add(hello2);
		
		return hellos;
		
	}
	
	
}
