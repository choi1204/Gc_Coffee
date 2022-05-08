// import { useEffect, useState } from "react";
//
// const detailComp = ({data}) => {
//     console.log(data)
//
//
//     return (
//         <>
//             <h2>Product Detail</h2>
//
//             <fieldset>
//                 <div className="mb-3">
//                     <label htmlFor="productId" className="form-label">Id</label>
//                     <h6 id="productId">{data.productId}</h6>
//                 </div>
//                 <div className="mb-3">
//                     <label htmlFor="exampleInputEmail1" className="form-label">Name</label>
//                     <h6 id="exampleInputEmail1">{data.productName}</h6>
//                 </div>
//                 <div className="mb-3">
//                     <label htmlFor="exampleInputPassword1" className="form-label">Category</label>
//                     <h6 id="exampleInputPassword1">{data.category}</h6>
//                 </div>
//             </fieldset>
//             <button type="submit" className="btn btn-primary btn-lg" role="button" aria-disabled="true">Delete</button>
//             {/* <a th:href="@{/product}" className="btn btn-secondary btn-lg" role="button" aria-disabled="true">Return</a> */}
//
//         </>
//     )
// }
//
// export default detailComp