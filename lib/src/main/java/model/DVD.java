package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class DVD extends Unidade{

	
	public DVD() {
		//Para o Hibernate
		super();
	}
	
	public DVD(int codigo, double preco) {
		super(codigo, preco);
	}
	
	@Override
	public String toString() {
		return super.toString() + " [DVD]";
	}

}

