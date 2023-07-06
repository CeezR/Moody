import { useEffect, useState } from 'react'
import './App.css'

type ResponseDto = {
  weatherDescription: string;
  genreName: string;
  genre_message: string;
}

function App() {
  
  const [testVar, setTestVar] = useState<ResponseDto>();
  const testFetch = async () => {

    try {
      const response = await fetch("http://localhost:8080/api")
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data:ResponseDto = await response.json();
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
        <p>Weather: {testVar?.weatherDescription}</p>
        <p>Genere: {testVar?.genreName}</p>
        <p>Message: {testVar?.genre_message}</p>
    </div>
  )
}

export default App
