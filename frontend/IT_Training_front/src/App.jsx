
import './App.css'
import { Outlet } from 'react-router-dom'
import Navbar from './components/shared/Navbar'

function App() {  

  return (
    <>
      <Navbar/>
      
      <main>
        <Outlet/>
      </main>
    </>
  )
}

export default App
