//import { Product } from "../../product";
import React, { Fragment, useState, useEffect } from "react";
//import Product from "../product"

import Stomp from "stompjs";
import "./styles2.scss"

export const Coffeebay = () => {
  const username= "";

  const [userOrder, setUserOrders] = useState({ products: [], isReady: false} );
  const [product, setProduct] = useState({ name: "", isReady: false });

  const connect = () => {
    let token = localStorage.getItem("jwtToken");
    let parsedToken = parseJwt(token);
    global.username = parsedToken.sub;
    console.log("username: ", parsedToken.sub)
    const socket = new WebSocket("ws://localhost:8080/coffeebay-socket");
    global.stompClient = Stomp.over(socket);
    global.stompClient.connect({}, onConnected, onError);
  }

  const parseJwt = (token) => {
    if (!token) {
      return;
    }
    const base64Url = token.split(".")[1];
    const base64 = base64Url.replace("-", "+").replace("_", "/");
    return JSON.parse(window.atob(base64));
  };

  const onConnected = () => {
    console.log("here")
    console.log("userORder: ", userOrder)
    global.stompClient.subscribe("/topic/public", onMessageReceived);
    global.stompClient.send("/app/chat.newUser",
      {},
      JSON.stringify({ sender: global.username, type: "CONNECT" })
    );

  };

  const onMessageReceived = (payload) => {
    const message = JSON.parse(payload.body);
    if(message.type === "CONNECT"){
      console.log("hi");
    }
    if(message.type === "CHAT"){
      console.log("hi2");
    }
  }
  
  const onError = (error) => {
      console.log("Could not find the connection you were looking for. Move along. Or, Refresh the page!");
  };

  const sendMessage =(e) => {
    e.preventDefault();
    let messageContent = userOrder;

    if(messageContent && global.stompClient) {
      const orderMessage = {
        sender: global.username,
        content: {"userOrder": messageContent},
        type: "CHAT",
      };
      global.stompClient.send(
        "/app/chat.send",
        {},
        JSON.stringify(orderMessage)
      );

    }
  }

  const inputChange = (e) => {
    // setOrders({ ...userOrder.products, [e.target.name]: e.target.value })
    setUserOrders({"products": [{"name":e.target.value}], "isReady": false})
  }

  const onSubmit = e => {
    
    e.preventDefault();

    // //orders.push(isReady: false)
    // setUserOrders({"products": [{"name":e.target.value}], "isReady": false})
    console.log(userOrder)

    //orders.push({name: product.name, isready: false})
    //setOrders(tempOrders)

    //orders.push(product)
    setProduct("")
    
    // console.log("order", orders)
    // console.log(product)
    //  const requestOptions = {
    //   method: "POST",
    //   headers: { "Content-Type": "application/json" },
    //   mode: "cors",
    //   body: JSON.stringify(product),
    // };

    //  fetch("http://localhost:8080/order/newOrder", requestOptions)

    //  .then((response) => response.json())
    
     //.then((json) => setOrders([...orders, json]))

    // .then((json) => setProduct(json))
    // .then(console.log("product: ", product))
     //.catch(function (error) {
       // console.log(error);
      //});
  }
  
  return (
    <Fragment>
      <div>
        <div>
          <form onSubmit={(e) => onSubmit(e)}>
            <label>Add Coffee</label>
            <input
              type="text"
              placeholder="What would you like to order"
              onChange={(e) => inputChange(e)}
            />
            <button type="submit">Add Coffee</button>
          </form>
          <form
                id="login-form"
                name="login-form"
                onSubmit={(e) => sendMessage(e)}
              >
                <div className="input-group">
                  <div className="input-group-append">
                    <button className="fas fa-location-arrow" type="submit">
                      Send
                    </button>
                  </div>
                </div>
              </form>
              <button onClick={() => {
                connect();
              }}>Connect</button>
        </div>

        <h1>ORDERS</h1>

      </div>
    </Fragment>

  );
}

