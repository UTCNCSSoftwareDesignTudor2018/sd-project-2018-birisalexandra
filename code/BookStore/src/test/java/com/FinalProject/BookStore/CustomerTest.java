package com.FinalProject.BookStore;

import com.FinalProject.BookStore.business.CustomerService;
import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.entity.ShippingInfo;
import com.FinalProject.BookStore.data.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class CustomerTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    CustomerService customerService;

    @Test
    public void shouldFindByUser() {
        User user = new User(15, "alebiris", "1234", 1);
        ShippingInfo info = new ShippingInfo(14, "Banat 19/7", 21, "0789123457");
        Customer customer = new Customer.CustomerBuilder().setCustomerId(5).setName("Biris Alexandra").setUser(user).setInfo(info).build();

        when(customerService.findByUser(user)).thenReturn(customer);
        assertTrue(customerService.findByUser(user).equals(customer));
    }

    @Test
    public void shouldListAllCustomers() {
        User user = new User(15, "alebiris", "1234", 1);
        ShippingInfo info = new ShippingInfo(14, "Banat 19/7", 21, "0789123457");
        Customer customer = new Customer.CustomerBuilder().setCustomerId(5).setName("Biris Alexandra").setUser(user).setInfo(info).build();

        User user2 = new User(13, "danutz", "lovekfc", 1);
        ShippingInfo info2 = new ShippingInfo(12, "21, caminul 7", 22, "0789456123");
        Customer customer2 = new Customer.CustomerBuilder().setCustomerId(3).setName("Harangus Dan").setUser(user2).setInfo(info2).build();

        User user3 = new User(16, "ericd", "dume", 1);
        ShippingInfo info3 = new ShippingInfo(15, "Strada Lalelelor", 26, "0789123123");
        Customer customer3 = new Customer.CustomerBuilder().setCustomerId(6).setName("Dumea Eric").setUser(user3).setInfo(info3).build();

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);

        when(customerService.findAll()).thenReturn(customers);
        assertTrue(customerService.findAll().equals(customers));
    }

}
