package by.itacademy.javaenterprise.knyazev.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goods")
@NamedNativeQuery(name= "allGoods", query = "SELECT g FROM goods g")
public class Good {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "good_generator")
	@SequenceGenerator(name="good_generator", sequenceName = "good_seq", allocationSize = 2)
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 30, nullable = false)
	private String sort;
	
	@Column(length = 900, nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "category_id")	
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "producer_id")
	private Producer producer;	
}
