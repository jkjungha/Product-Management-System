package repository;

import domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepository {
    private Map<Long, Product> db = new ConcurrentHashMap<>();

    //데이터 삭제
    public void deleteById(Long id) {
        db.remove(id);
    }

    //데이터 저장
    public void save(Product product){
        db.put(product.getId(), product);
    }

    //데이터 추출
    public List<Product> findAll(){
        return new ArrayList<>(db.values());
    }

    //원하는 데이터 추출
    public Product findById(Long id){
        return db.get(id);
    }
}
