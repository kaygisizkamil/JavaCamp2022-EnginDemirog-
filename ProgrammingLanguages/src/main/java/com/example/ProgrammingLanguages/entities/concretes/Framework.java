package com.example.ProgrammingLanguages.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="frameworks")//uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Framework {
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	  @JoinColumn(name = "languages_id", nullable = false)
	  @JsonIgnore
	  private Languages language;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private String name;
	  
	

}
