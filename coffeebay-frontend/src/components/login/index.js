import React from "react";
import "./styles.scss";

export const Login = ({ userinfo, setUserinfo }) => {
  const inputChange = (e) => {
    setUserinfo({ ...userinfo, [e.target.name]: e.target.value });
  };
  const submit = (e) => {
    e.preventDefault();

    const requestOptions = {
      method: "Post",
      headers: { "Content-tType": "application/json" },
      mode: "cors",
      body: JSON.stringify(userinfo),
    };

    fetch("<<URL>>", requestOptions)
      .then(function (response) {
        return response.json();
      })
      .then(function (data) {
        if (data.jwt) {
          localStorage.setItem("JWT", data.jwt);
        }
      })
      .catch(function (error) {
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
        <a href="/register">Create a new account</a>
      </div>
    </div>
  );
};
