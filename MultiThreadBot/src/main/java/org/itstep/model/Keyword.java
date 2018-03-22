package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table( name = "keywords" )
public class Keyword {

	@Id
	@Column(name="key")
	private String key;
	
	public Keyword() {
	}

	public Keyword(String key) {
		this.key = key;
	}
	
	
}