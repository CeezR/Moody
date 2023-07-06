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

    // try {
    //   const response = await fetch("http://localhost:8080/api")
    //   if (!response.ok) {
    //     throw new Error('Network response was not ok');
    //   }
    //   const data:moodyData = await response.json();
    //   setMoody(data);
      
    // } catch (error) {
    //   console.error('Error:', error);
    // }
  }

  useEffect(() => {
    testFetch();
  }, [])

  return (
    <main className='m-4'>
      <SearchForm/>
      <article className='my-3'>
      <MoodyCard weatherDescription={moody?.weatherDescription} genreName={moody?.genreName} genre_message={moody?.genre_message}/>
      </article>
    </main>
  )
}

export default Bord