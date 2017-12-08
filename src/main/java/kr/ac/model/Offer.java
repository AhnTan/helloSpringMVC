package kr.ac.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Offer {
	
	//private int num;
	private int year;
	private int term;
	private String subject;
	private String code;
	private String division;
	private int grade;
	
	/*private int id;
	
	@Size(min=2, max=100, message="Name must be between 2 and 100 chars") // name은 최소 2글자 최대 100글자 까지 설정
	private String name;
	
	@Email(message="Please provide a valid email address")
	@NotEmpty(message = "The email address cannot be empty")
	private String email;
	
	@Size(min=5, max=100, message="Name must be between 5 and 100 chars")
	private String text;*/
	
}
