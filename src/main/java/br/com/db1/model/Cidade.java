package br.com.db1.model;

import javax.persistence.*;

@Entity
@Table(name="cidade", schema="public")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uf_id", nullable = false)
	private Uf uf;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Uf getUf() {
		return uf;
	}


	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	
}
