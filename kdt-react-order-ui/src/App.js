import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React, {useEffect, useState} from 'react';
import Order from "./component/Order/Order"
import ProductList from "./component/Product/ProductList"
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";

function App() {
    console.log("hello");
    return (
        <Router>
            <Routes>
                <Route path='/order' element={<Order/>}/>
                {/*<Route path='/product' element={<ProductList/>}/>*/}
            </Routes>
        </Router>
    );
}

export default App;
