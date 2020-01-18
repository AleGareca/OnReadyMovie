import React, { Component } from 'react'
import Card from './Card';
import '../css/Imagen-card.css'


export default class Cards extends Component {


    renderCards() {
        return (<div className="card-deck mt-4 imagen-card">
            {this.props.peliculas.map(pelicula => <Card data={pelicula}/>)}
        </div>
        )
    }



    render() {
        return (
            <div>
                {this.renderCards()}
            </div>
        )
    }
}
