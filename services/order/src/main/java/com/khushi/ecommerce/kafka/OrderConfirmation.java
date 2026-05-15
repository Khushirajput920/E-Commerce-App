package com.khushi.ecommerce.kafka;

import com.khushi.ecommerce.customer.CustomerResponse;
import com.khushi.ecommerce.order.PaymentMethod;
import com.khushi.ecommerce.customer.CustomerResponse;
import com.khushi.ecommerce.order.PaymentMethod;
import com.khushi.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
