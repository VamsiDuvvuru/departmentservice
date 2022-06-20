package com.test.DepartmentService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="Principal_user")
public class PrincipalUser {
	
	@Id
	@Column(name="userid")
	private int userid;
	@Column(name="name")
	private String name;
	@Column(name="mailId")
	private String mailId;

}
