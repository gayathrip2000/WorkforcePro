import './App.css'
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
     </Routes>
     <FotterComponent/>
     </BrowserRouter>
    </>
  )
}

export default App
