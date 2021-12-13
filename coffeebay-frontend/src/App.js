import React, { useState } from "react";
import { Login } from "./components/login";
import { Register } from "./components/register";
import { Coffeebay } from "./components/coffeebay/Main";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "./App.css";  

export const App = () => {
  const [userInfo, setUserInfo] = useState({
    username: "",
    password: "",
    confPass: "",
    email: "",
    confEmail: "",
  });
  
  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  return (
    <div className="container">
      <Router>
        <Switch>
          <Route exact path="/">
            <Login user={user} setUser={setUser}/>
          </Route>          
          <Route exact path="/register">
            <Register userInfo={userInfo} setUserInfo={setUserInfo} />
          </Route>
          <Route excact path="/coffeebay">
            <Coffeebay userInfo={userInfo} setUserInfo={setUserInfo}/>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}
