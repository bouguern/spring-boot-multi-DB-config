package bouguern.tuto.demo.product;

import bouguern.tuto.demo.exceptions.ResourceNotFoundException;

public interface ProductService {

	public ProductDto createProduct(ProductDto productDto);

	public ProductDto getByProductId(Long productId) throws ResourceNotFoundException;

}
