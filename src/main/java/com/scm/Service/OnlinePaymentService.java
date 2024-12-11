package com.scm.Service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.scm.entity.OnlinePayment;
import com.scm.entity.Order;
import com.scm.repositery.OnlinePaymentRepo;

@Service
public class OnlinePaymentService {

		@Autowired
		private OnlinePaymentRepo orderRepo;

		private RazorpayClient client;

		
		@Value("${razorpay.key.id}")
		private String keyId;

		@Value("${razorpay.key.secret}")
		private String keySecret;

		public OnlinePayment createOrder(OnlinePayment stOrder) throws Exception {
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", stOrder.getAmount() * 100); // amount in paise
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", String.valueOf(stOrder.getEmail()));
			System.out.println(keyId);
			System.out.println(keySecret);
			this.client = new RazorpayClient(keyId, keySecret);
			com.razorpay.Order razorPayOrder = client.Orders.create(orderRequest);
			stOrder.setRazorPayOrderId(razorPayOrder.get("id"));
			stOrder.setOrderStatus(razorPayOrder.get("status"));
			orderRepo.save(stOrder);
			return stOrder;
		}
		public OnlinePayment verifyPaymentAndUpdateOrderStatus(Map<String, String> respPayload) {
			OnlinePayment onlinePayment = null;
			try {

				String razorpayOrderId = respPayload.get("razorpay_order_id");
				String razorpayPaymentId = respPayload.get("razorpay_payment_id");
				String razorpaySignature = respPayload.get("razorpay_signature");

				// Verify the signature to ensure the payload is genuine
				boolean isValidSignature = verifySignature(razorpayOrderId, razorpayPaymentId, razorpaySignature);

				if (isValidSignature) {
					onlinePayment = orderRepo.findByRazorPayOrderId(razorpayOrderId);
					if (onlinePayment != null) {
						onlinePayment.setOrderStatus("CONFIRMED");
						orderRepo.save(onlinePayment);
					}
				} else {
					System.out.println("invalid");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return onlinePayment;
		}
		private boolean verifySignature(String orderId, String paymentId, String signature) throws RazorpayException {
			String generatedSignature = HmacSHA256(orderId + "|" + paymentId, keySecret);
			return generatedSignature.equals(signature);
		}

		private String HmacSHA256(String data, String key) throws RazorpayException {
			try {
				javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
				javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(key.getBytes(),
						"HmacSHA256");
				mac.init(secretKeySpec);
				byte[] hash = mac.doFinal(data.getBytes());
				return new String(org.apache.commons.codec.binary.Hex.encodeHex(hash));
			} catch (Exception e) {
				throw new RazorpayException("Failed to calculate signature.", e);
			}
		}

	}



