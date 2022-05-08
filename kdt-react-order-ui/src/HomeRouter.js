import React from 'react';
import App from './App'
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';

class HomeRouter extends React.Component {
    render() {
        return (
            <Router>
                <Routes>
                    <Route path='/order' component={App} />
                </Routes>
            </Router>
        );
    }
}
export default HomeRouter;