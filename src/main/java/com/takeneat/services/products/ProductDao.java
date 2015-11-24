package com.takeneat.services.products;

import com.takeneat.services.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author paoesco
 */
public interface ProductDao extends JpaRepository<Product, Long>{
    
}
