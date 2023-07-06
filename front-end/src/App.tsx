import { useEffect, useState } from 'react'
import './App.css'

function App() {
  
  const [testVar, setTestVar] = useState("");
  const testFetch = async () => {

    try {
      const response = await fetch("http://localhost:8080/api")
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.text();
      setTestVar(data);
      
    } catch (error) {
      console.error('Error:', error);
    }
  }

  useEffect(() => {
    testFetch();
  }, [])

  return (
    <div className='m-5'>
      {testVar}
    </div>
  )
}

export default App
