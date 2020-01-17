import React, { Component } from 'react'
import {addMovie} from '../api/api'
import NavMovie from './NavMovie'


export default class AddMovie extends Component {
    constructor(props) {
       super(props);
      
   
       this.state = {
          nombre: '' ,
          url:'',
          sinopsis : '',
          paisDeOrigen: '',
          fecha:'',
          director: '',
    
          isSuccess: false,
          error:""
       };
  
       this.cambiarNombre = this.cambiarNombre.bind(this);
       this.cambiarUrl = this.cambiarUrl.bind(this);
       this.cambiarSinopsis = this.cambiarSinopsis.bind(this);
       this.cambiarPaisDeOrigen= this.cambiarPaisDeOrigen.bind(this);
       this.cambiarFecha = this.cambiarFecha.bind(this);
       this.cambiarDirector = this.cambiarDirector.bind(this);

       this.agregarPelicula = this.agregarPelicula.bind(this);

     }
  
     cambiarNombre(event) {
      this.setState({ nombre: event.target.value});
    }
  
    cambiarUrl(event) {
      this.setState({ url: event.target.value });
    }
    
    cambiarSinopsis(event) {
      this.setState({ sinopsis: event.target.value });
    }
  
    cambiarPaisDeOrigen(event){
        this.setState({paisDeOrigen:event.target.value});
    }
    cambiarFecha(event) {
      this.setState({ fecha: event.target.value });
    }
  
    cambiarDirector(event) {
      this.setState({ director: event.target.value });
    }
  
  
  
    renderSuccessModal() { 
      return (
        <div className="modal" tabindex="-1" role="dialog" style={{ display: this.state.isSuccess ? 'block' : '' }}>
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">{this.successTitle}</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close" onClick={() => this.setState({ isSuccess: false })}>
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                <p>{this.state.successMessage}</p>
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-primary" onClick={() => this.props.history.push('/')}>Volver al inicio</button>
              </div>
            </div>
          </div>
        </div>
        );
  
    }

  
    agregarPelicula() {
        addMovie({ nombre: this.state.nombre, url: this.state.url, sinopsis: this.state.sinopsis, paisDeOrigen: this.state.paisDeOrigen,fecha:this.state.fecha,director: this.state.director})
        .then((res)=>{   
          this.setState({ isSuccess: true, successMessage: res.message })
        }).catch((error) => {
          this.setState({ error: error.response.data.title })
        })
  
    
    }                
      
                           
  
    renderInput(label, value, inputType, onChange) {
      return (
     
        <div className="form-group row">
          
          <label className="col-sm-3 col-form-label">{label}</label>
          <div className="col-sm-9">
            <input label={ label} type={inputType} className="form-control" value={value} onChange={onChange} />
          </div>
        </div>
      );
    }
  
    
    render() {
      return (
        <React.Fragment>
        <NavMovie/>
        
        <div className="container">
          <div className="row centerRow">
            <div className="col-3" />
            <div className="col-6 card newCard">
            <h1> Agregar pelicula </h1>
            <div className="card-body">
            
                {this.renderInput('Nombre', this.state.nombre, 'text',this.cambiarNombre)}
                {this.renderInput('Url', this.state.url, 'text', this.cambiarUrl)}
                {this.renderInput('Sinopsis', this.state.sinopsis, 'text', this.cambiarSinopsis)}
                {this.renderInput('Pais', this.state.paisDeOrigen, 'text', this.cambiarPaisDeOrigen)}
                {this.renderInput('Fecha', this.state.fecha, 'text', this.cambiarFecha)}
                {this.renderInput('Director', this.state.director, 'text', this.cambiarDirector)}
               
               
                <div className="col-12">
                  <button type="button" className="btn btn-primary btn-block" onClick={this.agregarPelicula}>Aceptar</button>
                </div>
                <div className="col-12 " >
                  {this.state.error && this.state.error} 
                </div>
            </div>
          </div>
        </div>
        </div>
      
      
        {this.renderSuccessModal()}
        </React.Fragment>
      );
    }
  }