package com.conatus.conatussb.entities.reports;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RELATORIOS")
public class Report implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="COD_RELATORIO")
	@Id
	private Long id;
	
	@Column(name="DESCRICAO")
	private String description;
	
	@Column(name="DIRETORIO")
	private String directory;
	
	@Column(name="CATEGORIA")
	private String category;
	
	public Report () {
		super();
	}

	public Report(Long id, String description, String path, String category) {
		super();
		this.id = id;
		this.description = description;
		this.directory = path;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String path) {
		this.directory = path;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((directory == null) ? 0 : directory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (directory == null) {
			if (other.directory != null)
				return false;
		} else if (!directory.equals(other.directory))
			return false;
		return true;
	}
	
	
}
