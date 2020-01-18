import {
  BrowserRouter,
  Switch,
  Route,
} from "react-router-dom";
import './App.css';
import Home from './component/Home';
import React, { Component } from 'react'


export default class App extends Component {

  render() {
    return (
      <BrowserRouter>
        <Route>
          <Switch>
            <Route exact path="/" component={Home}/>
          </Switch>
        </Route>
      </BrowserRouter>);
  }
}