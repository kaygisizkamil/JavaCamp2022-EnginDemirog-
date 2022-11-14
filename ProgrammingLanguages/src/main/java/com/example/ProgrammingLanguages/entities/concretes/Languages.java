package com.example.ProgrammingLanguages.entities.concretes;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//alert uniqness will only work if u let the spring create the table  
@Table(name="p_languages")//uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Languages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	//@Column(name="name")
	private String name;
	

	@OneToMany(mappedBy= "language",cascade = CascadeType.ALL, orphanRemoval = true)
	 List<Framework> frameworks;

}
