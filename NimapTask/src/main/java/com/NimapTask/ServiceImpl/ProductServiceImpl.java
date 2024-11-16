package com.NimapTask.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.NimapTask.Category;
import com.NimapTask.Product;
import com.NimapTask.Repository.CategoryRepository;
import com.NimapTask.Repository.ProductRepository;
import com.NimapTask.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Product createProduct(Product product) {
        // Validate category exists
        if (product.getCategory() != null) {
            Long categoryId = product.getCategory().getId();
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow();
            product.setCategory(category);
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());

        if (productDetails.getCategory() != null) {
            Long categoryId = productDetails.getCategory().getId();
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow();
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

//	@Override
//	public Product createProduct(Product product) {
//		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
//	}
//
//	@Override
//	public Product updateProduct(Long id, Product product) {
//		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
//	}
}

