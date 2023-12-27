import './App.css'
import EmployeeComponent from './components/EmployeeComponent'
import FotterComponent from './components/FotterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeCompnent from './components/ListEmployeeCompnent'
import {BrowserRouter,Route, Routes} from 'react-router-dom'

function App() {
 

  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>
    <Routes>
    <Route path="/" element={<ListEmployeeCompnent />} exact />
    <Route path="/employees" element={<ListEmployeeCompnent />} exact />
    <Route path="/add-employee" element={<EmployeeComponent />} exact />
     </Routes>
     <FotterComponent/>
     </BrowserRouter>
    </>
  )
}

export default App
