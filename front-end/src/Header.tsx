import React from 'react'
import log from './assets/Screenshot 2023-07-05 at 10.16.04.png'

const Header = () => {
  return (
    <nav className="navbar">
      <img src={log} alt="Logo" width="150" className="mx-auto d-block align-text-top" />
    </nav>
  )
}

export default Header