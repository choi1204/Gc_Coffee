// function Product() {
//
//
//
//     return (
//         <h2>Product Detail</h2>
//     <form th:action="@{/product/delete/{productId} (productId = ${product.productId})}" method="post">
//         <fieldset>
//             <div className="mb-3">
//                 <label htmlFor="productId" className="form-label">Id</label>
//                 <h6 th:text="${product.productId}" id="productId"></h6>
//             </div>
//             <div className="mb-3">
//                 <label htmlFor="exampleInputEmail1" className="form-label">Name</label>
//                 <h6 th:text="${product.productName}" id="exampleInputEmail1"></h6>
//             </div>
//             <div className="mb-3">
//                 <label htmlFor="exampleInputPassword1" className="form-label">Category</label>
//                 <h6 th:text="${product.category}" id="exampleInputPassword1"></h6>
//             </div>
//         </fieldset>
//         <button type="submit" className="btn btn-primary btn-lg" role="button" aria-disabled="true">Delete</button>
//         <a th:href="@{/product}" className="btn btn-secondary btn-lg" role="button" aria-disabled="true">Return</a>
//     </form>
//     )
// }
