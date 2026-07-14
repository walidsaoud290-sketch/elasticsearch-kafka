import React from 'react'
import {BrowserRouter, Route, Routes} from "react-router-dom"
import CreateBooks from '../home/CreateBooks'
import Search from '../search/Search'
const RoutesApp = () => {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<CreateBooks />} />
            <Route path='/list' element={<Search />} />
        </Routes>
    </BrowserRouter>    
    
  )
}

export default RoutesApp