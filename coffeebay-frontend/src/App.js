import React, { useState } from "react";
import { Login } from "./components/login";
import { Register } from "./components/register";
import { Coffeebay } from "./components/coffeebay";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "./App.css";  

export const App = () => {
  const [userInfo, setUserInfo] = useState({
    name: "",
    password: "",
    confPass: "",
    email: "",
    confEmail: "",
  });

  return (
    <div className="container">
      <Router>
        <Switch>
          <Route exact path="/">
            <Login userInfo={userInfo} setUserInfo={setUserInfo}/>
          </Route>
          <Route excact path="/coffeebay">
            <Coffeebay userInfo={userInfo} setUserInfo={setUserInfo}/>
          </Route>
          <Route exact path="/register">
            <Register userinfo={userInfo} setUserInfo={setUserInfo} />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}
