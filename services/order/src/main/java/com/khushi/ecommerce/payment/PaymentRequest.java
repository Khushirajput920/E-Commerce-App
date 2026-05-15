package com.khushi.ecommerce.payment;

import com.khushi.ecommerce.customer.CustomerResponse;
import com.khushi.ecommerce.order.PaymentMethod;
import com.khushi.ecommerce.customer.CustomerResponse;
import com.khushi.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
