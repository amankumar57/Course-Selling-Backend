package com.scm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import 	jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Table

public class Payment {
	
	//id, orderId, paymentMethod, paymentStatus, transactionId
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
//	private String orderId;

	 @OneToOne
	    @JoinColumn(name = "order_id")
	    private Order order;

	    private String paymentMethod;
	    private String paymentStatus;
	    private String transactionId;
		
}
