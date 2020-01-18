import React, { Component } from 'react'
import '../css/Imagen-card.css'


export default class Card extends Component {
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
                                    <a href=".." className="btn btn-primary">Go somewhere</a>
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
