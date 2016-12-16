package fr.afcepf.al29.dionychus.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("testAdminManagedBean")
@Scope("request")
public class TestAdminManagedBean {

	private int i=2;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	public String essai(){
		if(i == 2){
		i = 3;
		} else {
			i = 2;
		}
		return null;
	}
	
}
