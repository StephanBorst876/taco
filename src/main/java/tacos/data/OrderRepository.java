package tacos.data;

import tacos.domain.Order;

/**
 *
 * @author FeniksBV
 */
public interface OrderRepository {
    
    Order save(Order order);
    
}
