package com.demo.microservi.services.impl;
import com.demo.microservi.models.ProductEntity;
import com.demo.microservi.repository.ProductRepository;
import com.demo.microservi.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        ProductEntity response =  productRepository.save(product);
        return response;
    }

    @Override
    public ProductEntity update(String Id, ProductEntity product) {
        Optional<ProductEntity> productUpd = this.findById(Id);
        if(productUpd.isEmpty()){
            return null;
        }
        productUpd.ifPresent(s->{
            s.setProductName(product.getProductName());
            s.setProductDescription(product.getProductDescription());
            s.setPriceUnit(product.getPriceUnit());
        });
        ProductEntity response = productRepository.save(productUpd.get());
        return response;
    }

    @Override
    public boolean deleteById(String id) {
        Optional<ProductEntity> product = this.findById(id);
        if(product.isEmpty()){
            return false;
        }
        productRepository.delete(product.get());
        return true;
    }
}
