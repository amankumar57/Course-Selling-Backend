package com.scm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "orders")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OnlinePayment {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer orderId;
		private String email;
		private Integer amount;
		private String orderStatus;
		private String razorPayOrderId;

		

}
