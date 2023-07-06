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

  return (
    <main className='m-4'>
      <SearchForm setMoody={setMoody}/>
      <article className='my-3'>
      <MoodyCard weatherDescription={moody?.weatherDescription} genreName={moody?.genreName} genre_message={moody?.genre_message}/>
      </article>
    </main>
  )
}

export default Bord