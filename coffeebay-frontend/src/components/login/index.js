import React from "react";
import "./styles.scss";
import { useHistory } from "react-router-dom"

export const Login = ({ user, setUser }) => {
  let history = useHistory(); 
  const inputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };
  const submit = (e) => {
    e.preventDefault();

    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      mode: "cors",
      body: JSON.stringify(user),
    };

    fetch("http://localhost:8080/user/authenticate", requestOptions)
    .then(function (response){return response.json();})
    .then(function (data) {
        if(data.jwt) {
          localStorage.setItem("JWT", data.jwt);
          history.push("/coffeebay")
        }
      }).catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="body">
      <form className="form" onSubmit={(e) => submit(e)}>
        <h1 className="login-title">COFFEEBAY</h1>
        <input
          name="username"
          type="text"
          className="input"
          placeholder="Username"
          onChange={(e) => inputChange(e)}
        ></input>
        <input
          type="password"
          className="input"
          name="password"
          onChange={(e) => inputChange(e)}
          placeholder="Password"
        ></input>
        <div>
          <button className="button" type="submit">
            Login
          </button>
          <p className="p">Forgot password?</p>
        </div>
      </form>
      <div className="register">
        <a href="/register">Create a new account ☕</a>
      </div>
    </div>
  );
};
