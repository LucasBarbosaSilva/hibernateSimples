package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Blueray extends Unidade{

	
	public Blueray() {
		//Para o Hibernate
		super();
	}
	
	public Blueray(int codigo, double preco) {
		super(codigo, preco);
	}
	
	@Override
	public String toString() {
		return super.toString() + " [BLUERAY]";
	}

}
