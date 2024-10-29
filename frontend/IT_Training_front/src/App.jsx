
import './App.css'
import { Outlet } from 'react-router-dom'
import Navbar from './components/shared/Navbar'

function App() {  

  return (
    <>
      <Navbar/>
      
      <div id='master'>
        <Outlet/>
      </div>
    </>
  )
}

export default App
