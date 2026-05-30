package service;

import common.ErrorCode;
import domain.Product;
import exception.BusinessException;
import repository.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(){
        this.productRepository = new ProductRepository();
    }

    //상품 등록(Create)
    public void registerProduct(Product product){
        Product findProduct = productRepository.findById(product.getId());

        if(findProduct != null){
            throw new BusinessException(ErrorCode.PRODUCT_ALREADY_EXISTS);
        }else {
            productRepository.save(product);
        }
    }

    //상품 조회(Read)
    public Product getProduct(Long id){
        Product findProduct = productRepository.findById(id);

        if(findProduct == null){
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUND);
        }else{
            return findProduct;
        }
    }

    //모든 상품 조회(Read)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //상품 수정(Update)
    public void updateProduct(Product product){
        Product findProduct = productRepository.findById(product.getId());

        if(findProduct != null){
            findProduct.setName(product.getName());
            findProduct.setPrice(product.getPrice());
            findProduct.setStock(product.getStock());
            productRepository.save(findProduct);
        }else{
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUND);
        }
    }

    //상품 삭제(Delete)
    public void deleteProduct(Long id){
        Product findProduct = productRepository.findById(id);

        if(findProduct == null){
            throw new BusinessException(ErrorCode.PRODUCT_NOT_FOUND);
        }else {
            productRepository.deleteById(id);
        }
    }
}
