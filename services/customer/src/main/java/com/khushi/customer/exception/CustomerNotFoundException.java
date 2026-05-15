package com.khushi.customer.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


public class CustomerNotFoundException extends RuntimeException {

   public CustomerNotFoundException(String message) {
      super(message);
   }
}

