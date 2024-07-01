package bouguern.tuto.demo.product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public static ProductDto toProductDto(Product productEntity) {

		if (productEntity == null)
			return null;

		return ProductDto.builder()
				.productId(productEntity.getProductId())
				.name(productEntity.getName())
				.build();
	}

	public static Product toProductEntity(ProductDto productDto) {

		if (productDto == null)
			return null;

		return Product.builder()
				.productId(productDto.getProductId())
				.name(productDto.getName())
				.build();
	}

}
