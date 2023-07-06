import React, { useEffect, useState } from 'react'
import SearchForm from './SearchForm'
import MoodyCard from './MoodyCard'

type moodyData = {
  weatherDescription: string;
  genreName: string;
  genre_message: string;
}

const Bord = () => {
  const [moody, setMoody] = useState<moodyData>();
  const testFetch = async () => {

    try {
      const response = await fetch("http://localhost:8080/api")
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data:moodyData = await response.json();
      setMoody(data);
      
    } catch (error) {
      console.error('Error:', error);
    }
  }

  useEffect(() => {
    testFetch();
  }, [])

  return (
    <>
      <SearchForm/>
      <MoodyCard weatherDescription={moody?.genreName} genreName={moody?.genreName} genre_message={moody?.genre_message}/>
    </>
  )
}

export default Bord