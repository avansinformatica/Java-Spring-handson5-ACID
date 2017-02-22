package sample.web.ui.repository;

import org.springframework.data.repository.CrudRepository;

import sample.web.ui.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
