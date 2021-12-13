import { Product } from "../../product";
import React, { Fragment, useState } from "react";
import Stomp from "stompjs";
import "./styles2.scss"

export const Coffeebay = () => {

  const [orders, setOrders] = useState([], false);
  const [product, setProduct] = useState({ name: "", isReady: false });

  const connect = (e) => {
    e.preventDefault();
    const socket = new WebSocket("ws://localhost:8080/coffeebay-socket");
    global.stompClient = Stomp.over(socket);
    global.stompClient.connect({}, onConnected, onError);
  }

  const onConnected = () => {
    console.log()
    global.stompClient.subscribe("/topic/public", onMessageReceived);
    global.stompClient.send("/app/order/coffee",
      {},
      JSON.stringify({ content: orders, type: "CONNECT" })
    );

  };

  const onMessageReceived = (payload) => {
    const message = JSON.parse(payload.body);
    if(message.type === "CONNECT"){
      console.log("hi");
    }
  }
  
  const onError = (error) => {
      console.log("Could not find the connection you were looking for. Move along. Or, Refresh the page!");
  };

  

  const onSubmit = e => {
    e.preventDefault();

    setOrders(e.name);
    setProduct(e.name);
    //orders.push()

    //const tempOrders = [...orders]

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
    
  // const onChange = (e) => {
  //   setProduct({ ...product, [e.target.name]: e.target.value });
  // }

  // const completeOrder = index => {
  //   const newOrders = [...orders];
  //   newOrders[index].completed = true;
  //   setOrders(newOrders)
  // }

  // const removeOrder = index => {
  //   const newOrders = [...orders];
  //   newOrders.splice(index, 1);
  //   setOrders(newOrders);
  // }
  
  
  return (
    <Fragment>
      <div>
        <div>
          <form onSubmit={(e) => onSubmit(e)}>
            <label>Add Coffee</label>
            <input
              type="text"
              placeholder="What would you like to order"
              onChange={(e) => setProduct(e.target.value)}
            />
            <button type="submit">Add Coffee</button>
          </form>
          <form
                id="login-form"
                name="login-form"
                onSubmit={(e) => connect(e)}
              >
                <div className="input-group">
                  <div className="input-group-append">
                    <button className="fas fa-location-arrow" type="submit">
                      Connect
                    </button>
                  </div>
                </div>
              </form>
        </div>

        <h1>ORDERS</h1>
        <Product orders={orders} setOrders={setOrders} />
      </div>
    </Fragment>

    // <div className="order-container">
    //   <div className="header">ORDERS</div>
    //     <div className="orders">
    //         {orders.map((product, index) => (
    //         <div key={product.name}
    //         className="order"
    //         style={{ textDecoration: product.completed ? "line-through" : ""}}
    //         >
    //         {product.name}

    //         <button style={{ background: "#ff0003" }} onClick={() => removeOrder(index)}>x</button>
    //         <button onClick={() => completeOrder(index)}>Complete</button>

    //       </div>
    //       ))}
    //     </div>

    //   <div className="create-order" >
    //     <form className="form" onSubmit={(e) => onSubmit(e)}>
    //       <input
    //       name="name"
    //       type="text"
    //       className="input"
    //       placeholder="Add your coffee"
    //       onChange={(e) => onChange(e)}
    //       ></input>
    //       <button className="button" type="submit">
    //       Add Coffee
    //       </button>
    //     </form>
    //   </div>
    // </div>
  );
}

