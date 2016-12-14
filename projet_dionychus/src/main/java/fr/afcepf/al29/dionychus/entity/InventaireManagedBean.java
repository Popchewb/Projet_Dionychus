package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaireAccessoire;
import fr.afcepf.al29.dionychus.entity.Article;

@RequestScoped
@ManagedBean
@Controller
public class InventaireManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IBusinessInventaireAccessoire proxyAccessoire;
	
	private List<Article> accessoires;

	public List<Article> getAccessoires() {
		System.out.println("méthode get");
		System.out.println("proxy " + proxyAccessoire);
		accessoires = new ArrayList<>();
//		Article article1 = new Article(1, "123456", "tire bouchon", 10.5, 30, 5, "plop");
//		Article article2 = new Article(2, "123457", "verre", 20., 50, 10, "plop2");
//		Article article3 = new Article(3, "123458", "dropstop", 18.5, 10, 6, "plop3");
//		Article article4 = new Article(4, "123459", "collier", 19.5, 20, 7, "plop4");
//		Article article5 = new Article(5, "123455", "thermomètre", 13.5, 40, 8, "plop5");
//		Collections.addAll(accessoires, article1, article2, article3, article4, article5);
//		return proxyAccessoire.getAllAccessoires();
		return accessoires;
	}

	public void setAccessoires(List<Article> accessoires) {
		this.accessoires = accessoires;
	}
	
}
