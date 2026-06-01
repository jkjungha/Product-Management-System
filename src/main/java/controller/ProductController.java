package controller;

import domain.Product;
import dto.ProductRequestDto;
import dto.ProductResponseDto;
import exception.BusinessException;
import service.ProductService;

import java.util.List;

public class ProductController {
    private final ProductService productService;

    public ProductController(){
        productService = new ProductService();
    }

    public ProductResponseDto handleRequest(ProductRequestDto productRequestDto){
        ProductResponseDto responseDto = new ProductResponseDto();

        try {
            String command = productRequestDto.getCommand();
            if (command.equals("CREATE")) {
                Product product = new Product(
                        productRequestDto.getId(),
                        productRequestDto.getName(),
                        productRequestDto.getPrice(),
                        productRequestDto.getStock()
                );
                productService.registerProduct(product);

                responseDto.setSuccess(true);
                responseDto.setMessage("상품 등록 완료");
            } else if (command.equals("READ")) {
                Long id = productRequestDto.getId();
                Product findProduct = productService.getProduct(id);

                responseDto.setSuccess(true);
                responseDto.setMessage("상품 조회 완료");

                responseDto.setId(findProduct.getId());
                responseDto.setName(findProduct.getName());
                responseDto.setPrice(findProduct.getPrice());
                responseDto.setStock(findProduct.getStock());
            } else if (command.equals("READ_ALL")) {
                List<Product> findProducts = productService.getAllProducts();

                responseDto.setSuccess(true);
                responseDto.setMessage("전체 상품 조회 완료");

                responseDto.setProducts(findProducts);
            } else if (command.equals("UPDATE")) {
                Product product = new Product(
                        productRequestDto.getId(),
                        productRequestDto.getName(),
                        productRequestDto.getPrice(),
                        productRequestDto.getStock()
                );
                productService.updateProduct(product);

                responseDto.setSuccess(true);
                responseDto.setMessage("상품 수정 완료");
            } else if (command.equals("DELETE")) {
                Long id = productRequestDto.getId();
                productService.deleteProduct(id);

                responseDto.setSuccess(true);
                responseDto.setMessage("상품 삭제 완료");
            } else {
                responseDto.setSuccess(false);
                responseDto.setMessage("잘못된 명령어");
            }
        }catch (BusinessException e){
            responseDto.setSuccess(false);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }
}
