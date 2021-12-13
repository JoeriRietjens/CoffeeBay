import React from "react";
import "./styles.scss";
import { useHistory } from "react-router";

export const Register = ({ userInfo, setUserInfo }) => {
  let history = useHistory();
  const inputChange = (e) => {
    setUserInfo({ ...userInfo, [e.target.name]: e.target.value });
  }
  const submit = (e) => {
    e.preventDefault();

    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      mode: "cors",
      body: JSON.stringify(userInfo),
    };
    console.log(userInfo)
    fetch("http://localhost:8080/user/register", requestOptions).then(
      (res) => {
      console.log(res);
        if (res.ok) {
          history.push("/")
      }
    });
  };

  return (
    <div className="body">
      <form className="form" onSubmit={(e) => submit(e)}>
        <h1 className="login-title">Register</h1>
       <input
          type="text"
          className="input"
          name="username"
          onChange={(e) => inputChange(e)}
          placeholder="Username"
        ></input>
        <input
          type="password"
          className="input"
          name="password"
          onChange={(e) => inputChange(e)}
          placeholder="Password"
        ></input>
        <input
          type="password"
          className="input"
          name="confPass"
          onChange={(e) => inputChange(e)}
          placeholder="Confirm password"
        ></input>
        <input
          type="email"
          className="input"
          name="email"
          onChange={(e) => inputChange(e)}
          placeholder="Enter your email"
        ></input>
        <input
          type="email"
          className="input"
          name="confEmail"
          onChange={(e) => inputChange(e)}
          placeholder="confirm your email"
        ></input>
        <div>
          <button className="button" type="submit">
            Sign up!
          </button>
        </div>
      </form>
    </div>
  );
};
