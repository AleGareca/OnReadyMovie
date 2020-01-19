import React, { Component } from 'react'
import '../css/Imagen-card.css'
import {remove} from '../api/api';


export default class Card extends Component {
    constructor(props) {
        super(props);
    this.deleteMovie= this.deleteMovie.bind(this)
    }


    deleteMovie(){
       remove("http://localhost:7000/movies/",{nombre:this.props.data.nombre})
    }



    render() {
        return (
            <div>
                
                <div className="container mt-4 imagen-card">
                    <div className="row">
                    <div className="col-md-2">
                        <div className="card" style={{ width: '18rem' }} >
                            <img  src={this.props.data.url} href=".." />
                                <div className="card-body">
                              
                                    <h5 className="card-title">{this.props.data.nombre}</h5>
                                    <p className="card-text">{this.props.data.sinopsis}</p>
                                    <div className= "card-footer text-muted">
                                    <button className="btn btn-primary">Borrar</button>
                                    <button className="btn btn-primary ml-5" >+ Info</button>
                                    </div>
                                </div>
                            
                        </div>
                    </div>
                    </div> 
                </div>
            </div>
        )
    }


}
