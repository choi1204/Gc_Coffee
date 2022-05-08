// import { useEffect, useState } from "react";
// import axios from "axios";
// import Detail from "./detail_compo"
//
// const ProductList = () => {
//
//     const [products, setProducts] = useState([]);
//
//     const getList = () =>{
//         axios('http://localhost:8080/api/product', {
//             method: 'get',
//             responseType: 'json'
//         })
//             .then((response) => {
//                 setProducts(response.data)
//             });
//     }
//
//     useEffect(() => {
//         getList()
//     }, [])
//
//     useEffect(() => {
//     }, [products])
//
//     const createFunc = () =>{
//
//     }
//     const detailFunc = (e) =>{
//         console.log(e.target.dataset.value);
//         <Detail
//         data = {e.target.dataset.value}
//             />
//     }
//
//
//     return (
//         <>
//             <h1>Product List</h1>
//
//             <div
//                 className="d-grid gap-2 d-md-flex justify-content-md-end">
//                 {/* <a th:href="@{/product/create}"
//                     className="btn btn-primary me-md-2" type="button"
//                 >Create
//                 </a> */}
//                 <button
//                     onClick={createFunc}
//                 >Create</button>
//             </div>
//
//             <table className="table table-striped table-hover">
//                 <thead>
//                 <tr>
//                     <th scope="col">ID</th>
//                     <th scope="col">Name</th>
//                     <th scope="col">Category</th>
//                     <th scope="col">Price</th>
//                     <th scope="col">Description</th>
//                     <th scope="col">etc</th>
//                 </tr>
//                 </thead>
//                 <tbody>
//                 {products.length !==0 && products.map(el => (
//                     <tr>
//                         <td>{el.productId}</td>
//                         <td>{el.productName}</td>
//                         <td>{el.category}</td>
//                         <td>{el.price}</td>
//                         <td>{el.description}</td>
//                         <td>
//                             <div className="d-grid gap-2 d-md-flex justify-content-md-end">
//                                 {/* <a th:href="@{/product/{productId} (productId = ${product.productId})}"
//                                     className="btn btn-primary me-md-2" type="button">detail</a> */}
//                                 <button
//                                     data-value={el}
//                                     onClick={detailFunc}
//                                 >detail</button>
//                             </div>
//                         </td>
//                     </tr>
//                 ))}
//                 </tbody>
//             </table>
//         </>
//     )
// }
//
// export default ProductList