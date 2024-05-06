package it.prova.gestioneprodotti.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "prodotto")
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "marca")
	private String marca;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "disponibile")
	private boolean disponibile;
	@Column(name = "data_creazione_prodotto")
	private LocalDate dataCreazioneProdotto;

	// campi per le time info del record
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Prodotto() {

	}

	public Prodotto(Long id, String nome, String descrizione, String marca, Integer prezzo, boolean disponibile,
			LocalDate dataCreazioneProdotto, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.marca = marca;
		this.prezzo = prezzo;
		this.disponibile = disponibile;
		this.dataCreazioneProdotto = dataCreazioneProdotto;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}

	public LocalDate getDataCreazioneProdotto() {
		return dataCreazioneProdotto;
	}

	public void setDataCreazioneProdotto(LocalDate dataCreazioneProdotto) {
		this.dataCreazioneProdotto = dataCreazioneProdotto;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}
