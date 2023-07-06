import React, { FormEvent, useEffect } from 'react'

type moodyData = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
  genre_upvotes : number | undefined;
  id : string | undefined;
}

type SearchFormProps = {
  setMoody : React.Dispatch<React.SetStateAction<moodyData | undefined>>
}

const SearchForm = ({setMoody} : SearchFormProps) => {
  
  const fetchMoody = async (latitude : string, longitude : string) => {
    try {
      const response = await fetch(`http://localhost:8080/api?longitude=${longitude}&latitude=${latitude}`)
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data:moodyData = await response.json();
      setMoody(data);
      
    } catch (error) {
      console.error('Error:', error);
    }
  }

  const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const latitude = (event.target as HTMLFormElement).elements.namedItem("latitude") as HTMLInputElement;
    const longitude = (event.target as HTMLFormElement).elements.namedItem("longitude") as HTMLInputElement;

    fetchMoody(latitude.value, longitude.value);
  }

  return (
    <form onSubmit={handleSubmit} id='addDeveloperForm'>
    <div className='row g-3 align-items-center'>
      <div className='col-6'>
        <label htmlFor="latitude">Latitude</label>
        <input
                type="text" 
                id="latitude" 
                name="latitude" 
                className="form-control form__input-name" 
                placeholder="59.3294"/>
      </div>
      <div className='col-6'>
        <label htmlFor="longitude">Longitude</label>
        <input
                type="text" 
                id="longitude" 
                name="longitude" 
                className="form-control form__input-name" 
                placeholder="18.0687"/>
      </div>
    </div>
    <button className='form__button-addDev btn btn-primary mx-auto d-block mt-3' type="submit" value="Submit">Submit</button>
  </form>
  )
}

export default SearchForm