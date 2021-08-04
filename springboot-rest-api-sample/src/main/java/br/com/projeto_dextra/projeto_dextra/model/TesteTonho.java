package br.com.projeto_dextra.projeto_dextra.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_tonho", sequenceName = "seq_tonho", allocationSize = 1, initialValue = 1)
@Table(name = "TB_TONHO")
public class TesteTonho implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tonho")
	private Long id;

	private String tonho;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTonho() {
		return tonho;
	}

	public void setTonho(String tonho) {
		this.tonho = tonho;
	}
}
