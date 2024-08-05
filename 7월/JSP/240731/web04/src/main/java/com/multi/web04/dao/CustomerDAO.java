package com.multi.web04.dao;

import com.multi.web04.vo.CustomerVO;

import java.util.HashMap;
import java.util.Map;

public class CustomerDAO {
    private Map<String, CustomerVO> customers = new HashMap<>();

    public void insertCustomer(CustomerVO customer) {
        customers.put(customer.getId(), customer);
    }

    public void deleteCustomer(String id) {
        customers.remove(id);
    }
}
