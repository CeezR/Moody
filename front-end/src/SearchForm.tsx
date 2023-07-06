import React, { useEffect } from 'react'

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
  
  const fetchMoody = async () => {
    // try {
    //   const response = await fetch("http://localhost:8080/api?longitude=59.3294&latitude=18.0687")
    //   if (!response.ok) {
    //     throw new Error('Network response was not ok');
    //   }
    //   const data:moodyData = await response.json();
    //   setMoody(data);
      
    // } catch (error) {
    //   console.error('Error:', error);
    // }
  }

  const handleSubmit = async () => {
    // event.preventDefault();
    // try {
    //   const response = await handleFetch();
      
    //   if (!response.ok) {
    //     setShowErrorAlert(true);
    //     setTimeout(() => setShowErrorAlert(false), 3000);
    //   } else {
    //     setShowSuccessAlert(fullName);
    //     setTimeout(() => setShowSuccessAlert(null), 3000);
    //     setFullName("");
    //     setBootcamp(Object.keys(Bootcamps)[0]);
    //     setRefetch(true);
    //   }
    // } catch (error) {
    //   console.error('Fetch failed:', error);
    // } 
  };

  useEffect(() => {
    fetchMoody();
  }, [])

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