# Gc_Coffee

온라인 웹사이트를 통해 커피 주문 관리 웹페이지 제작

##기술스택

- Spring boot(+jdbc api)
- Thymeleaf
- React
- MySql

##DB
- Products
```sql
CREATE TABLE products
(
    product_id bigint PRIMARY KEY auto_increment,
    product_name VARCHAR(20) unique NOT NULL,
    category VARCHAR(50) NOT NULL,
    price bigint NOT NULL,
    description VARCHAR(500) DEFAULT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) DEFAULT NULL
);
```
- Orders
```sql
CREATE TABLE orders
(
    order_id       bigint PRIMARY KEY auto_increment ,
    email           varchar(50) not null ,
    address         varchar(200) not null ,
    postcode        varchar(200) not null ,
    order_status    varchar(50) not null ,
    created_at      datetime(6) not null ,
    updated_at      datetime(6) not null
);
```
- Order_Item
```sql
create table order_items
(
    seq         bigint  not null primary key AUTO_INCREMENT,
    order_id    bigint(16) not null ,
    product_id  bigint(16) not null ,
    category    varchar(50) not null ,
    price       bigint not null ,
    quantity    int not null ,
    created_at  datetime(6) not null ,
    updated_at  datetime(6) default null,
    index (order_id),
    constraint fk_order_items_to_order FOREIGN KEY (order_id) REFERENCES orders (order_id) on delete cascade,
    constraint fk_order_items_to_product foreign key (product_id) references products(product_id)
);
```

##기능 구현

### Server(Spring boot)

- Rest 형식의 Api 설계.
- Thymeleaf를 활용한 MVC.
- Jdbc api를 통해 DB 연동.
- Cors 설정을 통한 Front와 통신.
- @ControllerAdvice를 통한 예외 핸들링.
- Spring-boot-validation을 통한 유효성 검사.
- test 코드 작성.

### Front(React)

- 주문 생성 페이지 제작.(라우터 적용)

### Front(Thymeleaf)
- mvc 기반의 Product 관리 페이지

## 기존코드와의 차이점

- PK값이 UUID가 아닌 DB의 Auto Increment를 사용한 Long 형식의 데이터타입.
- 제품관리 페이지 제작.
- @ControllerAdvice를 통한 예외 핸들링 추가.
- validation을 통한 유효성 검사.

