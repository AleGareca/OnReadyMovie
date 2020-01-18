import React, { Component } from 'react'
import logo from '../img/logo.svg'

export default class NavBar extends Component {
    render() {
        return (
            <div>
            <nav className="navbar navbar-dark bg-dark ml-auto fixed-top" >
                <a className="navbar-brand" href= "..">
                    <img src={logo}
                    width="30" height="30" alt=""/>OnReadyMovies
                </a>
          </nav>
          </div>
                )
    }
}