package bouguern.tuto.demo.product;

import org.springframework.stereotype.Service;

import bouguern.tuto.demo.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public ProductDto createProduct(ProductDto productDto) {

		log.info("Creating a new Product -> {}", productDto);

		return ProductMapper.toProductDto(productRepository.save(ProductMapper.toProductEntity(productDto)));
	}

	@Override
	public ProductDto getByProductId(Long productId) throws ResourceNotFoundException {

		log.info("Finding the Product with productID : {}", productId);
		return ProductMapper.toProductDto(productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product with id " + productId + " not found")));
	}

}
