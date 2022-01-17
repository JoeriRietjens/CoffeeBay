import React, { useState } from "react";
import { Coffeebay } from "./components/coffeebay";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";

export const App = () => {
  return (
    <div className="container">
      <Router>
        <Routes>
          <Route exact path="/" element={<Coffeebay/>}/>
        </Routes>
      </Router>
    </div>
  );
}
