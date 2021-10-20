import React, { useState } from "react";
import { Login } from "./components/login";
import { Coffeebay } from "./components/coffeebay";
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

  return (
    <div className="container">
      <Router>
        <Switch>
          <Route exact path="/">
            <Login userinfo={userInfo} setUserInfo={setUserInfo}/>
          </Route>
          <Route excact path="/coffeebay">
            <Coffeebay userinfo={userInfo} setUserInfo={setUserInfo}/>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}
