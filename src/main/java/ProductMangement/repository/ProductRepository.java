package ProductMangement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import ProductMangement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
