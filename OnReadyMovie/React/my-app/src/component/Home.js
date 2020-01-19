import React, { Component } from 'react'
import NavBar from './NavBar';
import Cards from './Cards';
import axios from 'axios';



export default class Home extends Component {

    constructor(props) {
        super(props);
    
        this.state = {
          peliculas: [],
        };

    }
    componentDidMount(){
        axios.get("http://localhost:7002/movies")	   
        .then((res=>{  
                this.setState({peliculas:res.data}); 
                console.log(res.data)
                }))
       }



    render() {
        return (
            <div>
                <NavBar/>
                <Cards peliculas={this.state.peliculas}/>
               
            </div>
        )
    }
}