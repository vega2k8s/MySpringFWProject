package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	ShoppingCart cart;
	
	@Autowired
	OrderService service;
    
    //ShoppingCart 검증
    @Test
    public void testShoppingCart() {        
        assertNotNull(cart);
        assertEquals(2, cart.getProducts().size());
        /*
         * cart.getProducts() => List<Product>
         * cart.getProducts().get(0) => Product
         * cart.getProducts().get(0).getName() => String
         */
        assertEquals("노트북", cart.getProducts().get(0).getName());
        assertEquals("스마트폰", cart.getProducts().get(1).getName());
    }

    //OrderService 검증
    @Test //@Disabled
    public void testOrderService() {               
        // 검증
        assertNotNull(service);
        //service.getShoppingCart() => ShoppingCart
        assertNotNull(service.getShoppingCart());
        assertEquals(2300000.0, service.calculateOrderTotal(), 0.001);
    }
}