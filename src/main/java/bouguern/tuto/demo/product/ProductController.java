package bouguern.tuto.demo.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouguern.tuto.demo.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
		log.info("Creating a new Product -> {}", productDto);
		ProductDto savedProduct = productService.createProduct(productDto);
		log.info("Product created successfully -> {}", savedProduct);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> getByProductId(@PathVariable("productId") Long productId)
			throws ResourceNotFoundException {
		log.info("Searching the product with productId -> {}", productId);
		ProductDto returnedProduct = productService.getByProductId(productId);
		log.info("The product with productId : {} is found", productId);
		return new ResponseEntity<>(returnedProduct, HttpStatus.OK);

	}

}
