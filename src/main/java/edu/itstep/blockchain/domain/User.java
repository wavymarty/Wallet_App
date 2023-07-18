package edu.itstep.blockchain.domain;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user_accounts")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="ID_USER")
 private Long id;
 
// @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
// private Set<WalletAddress> wa;
 
 private String name;
 
 private String password;
}
