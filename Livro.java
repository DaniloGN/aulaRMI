//
//  Livro.java
//  

import java.io.Serializable;

public class Livro implements Serializable {
	
	private int isbn;
	private String titulo;
	private int ano;
	
	public Livro (int isbn, String titulo, int ano) { 
		this.isbn = isbn;
		this.titulo = titulo;
		this.ano = ano;
		}
	
	public void setIsbn (int i) {
		isbn = i;
	}
	
	public int getIsbn () {
		return isbn;	  
	}
	
	public void setTitulo (String t) {
		titulo = t;
	}
	
	public String getTitulo () {
		return titulo;	  
	}
	
	public void setAno (int a) {
		ano = a;
	}
	
	public int getAno () {
		return ano;	  
	}

}
