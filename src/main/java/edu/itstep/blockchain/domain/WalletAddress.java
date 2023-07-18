package edu.itstep.blockchain.domain;

import java.security.PrivateKey;
import java.security.PublicKey;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="wallet_address")
public class WalletAddress {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="WALLET_ID")
	 private Long id;
	 @ManyToOne(cascade= CascadeType.ALL)
	 @JoinColumn(name = "ID_USER")
	 private User user;
	 @Column(name="public_key")
	 private PublicKey publicKey;
	 @Column (name="private_key")
	 private PrivateKey privateKey;
}
