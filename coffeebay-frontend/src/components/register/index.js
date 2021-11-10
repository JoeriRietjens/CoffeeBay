import React from "react";
import "./styles.scss";

export const Register = ({ userinfo, setUserInfo }) => {
  
  const inputChange = (e) => {
    setUserInfo({ ...userinfo, [e.target.name]: e.target.value });
  }
  const submit = (e) => {
    e.preventDefault();

    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(userinfo),
    };
    console.log(userinfo)
    fetch("http://localhost:8080/user/register", requestOptions).then(
      (res) => {
        console.log(res);
        console.log(res.data);
      } 
    );
  };

  return (
    <div className="body">
      <form className="form" onSubmit={(e) => submit(e)}>
        <h1 className="login-title">Register</h1>
       <input
          name="name"
          type="text"
          className="input"
          placeholder="Name"
          onChange={(e) => inputChange(e)}
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
