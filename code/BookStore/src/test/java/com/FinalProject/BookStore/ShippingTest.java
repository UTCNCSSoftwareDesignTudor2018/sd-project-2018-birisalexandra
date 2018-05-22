package com.FinalProject.BookStore;

import com.FinalProject.BookStore.business.ShippingService;
import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.entity.ShippingInfo;
import com.FinalProject.BookStore.data.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

public class ShippingTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    ShippingService shippingService;

    @Test
    public void shouldFindByPhone1() {
        User user = new User(15, "alebiris", "1234", 1);
        ShippingInfo info = new ShippingInfo(14, "Banat 19/7", 21, "0789123457");

        when(shippingService.findByPhone("0789123457")).thenReturn(info);
        assertTrue(shippingService.findByPhone("0789123457").equals(info));
    }

    @Test
    public void shouldFindByPhone2() {
        User user2 = new User(13, "danutz", "lovekfc", 1);
        ShippingInfo info2 = new ShippingInfo(12, "21, caminul 7", 22, "0789456123");

        when(shippingService.findByPhone("0789456123")).thenReturn(info2);
        assertTrue(shippingService.findByPhone("0789456123").equals(info2));
    }

    @Test
    public void shouldCheckAge() {
        ShippingInfo info2 = new ShippingInfo(12, "21, caminul 7", 22, "0789456123");

        when(shippingService.checkAge(info2)).thenReturn(true);
        assertTrue(shippingService.checkAge(info2));
    }
}
