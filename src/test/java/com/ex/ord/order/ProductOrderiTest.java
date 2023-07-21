package com.ex.ord.order;

import com.ex.ord.ProductStep;
import com.ex.ord.adapter.ProductAdapter;
import com.ex.ord.adapter.ProductBeanAdapter;
import com.ex.ord.create.ApiTest;
import com.ex.ord.entity.Order;
import com.ex.ord.entity.Product;
import com.ex.ord.repository.ProductDbRepository;
import com.ex.ord.repository.ProductPort;
import com.ex.ord.repository.ProductRepository;
import com.ex.ord.service.ProductService;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.OptionalLong;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * fileName:ProductSelectTest
 * 작성날짜:2023-07-20
 * desc :
 **/

class ProductOrderiTest extends ApiTest {

    @Autowired
    private ProductService productService; // 상품 등록 서버스


    private ProductPort productPort;
    //@Autowired

    @Autowired
    private  ProductDbRepository productDbRepository;

    @BeforeEach
    void setUp() {
    }
    @Test
    void 상품_주문_테스트()
    {
        // 등록
        ProductStep.상품등록();
        // 조회
        Long productId =1L;
        ExtractableResponse<Response> response = ProductStep.조회등록(productId);
        // 조회 검증
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("노트북");
        // 조회 상품 리턴
        Product product = response.body().as(Product.class);
        // 주문 생성
        final OrderRequest orderRequest = new OrderRequest(  product , 7);

        OrderPort orderPort = new OrderPort(){
            @Override
            public void save(Order order) {
                System.out.println(" = 주문저장"  );
            }
        };

        ProductPort productPort = new ProductBeanAdapter(productDbRepository);
        OrderService orderService  = new OrderService(productPort ,orderPort );
        orderService.createOrder(orderRequest);
    }

    private class OrderRequest {
        private final Product product;
        private final int quantity ;

        public OrderRequest(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }
    }




    class OrderService {
        private final ProductPort productPort;
        private final OrderPort orderPort;

        public OrderService(ProductPort productPort, OrderPort orderPort) {
            this.productPort = productPort;
            this.orderPort = orderPort;
        }

        public void createOrder(OrderRequest orderRequest) {
            // 주문 상품 확인 하기
            OptionalLong id = OptionalLong.of(orderRequest.getProduct().getId());
            if(Optional.of(productPort.getProudct(id.getAsLong())).isPresent()){
                // 주문생성
                final Order order = new Order(orderRequest.getProduct() ,orderRequest.getQuantity());
                orderPort.save(order);
            }

        }
    }

     interface OrderPort {
        void save(Order order);
    }

    class OrderAdapter implements OrderPort{

        private final OrderRepository orderRepository;

        public OrderAdapter(OrderRepository orderRepository) {
            this.orderRepository = orderRepository;
        }

        @Override
        public void save(Order order) {
            orderRepository.save(order);

        }
    }

    interface OrderRepository extends CrudRepository<Order,Long> {
    }
}