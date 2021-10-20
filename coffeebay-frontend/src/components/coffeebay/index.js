import React, { useState } from "react";
import "./styles2.scss"

function Order({ order, index, completeOrder, removeOrder }) {
  return (
    <div
      className="order"
      style={{ textDecoration: order.completed ? "line-through" : "" }}
    >
      {order.name}

      <button style={{ background: "#ff0003" }} onClick={() => removeOrder(index)}>x</button>
      <button onClick={() => completeOrder(index)}>Complete</button>

    </div>
  );
}

function CreateOrder({ addOrder }) {
    const [orders, setOrders] = useState("");
  
    const handleSubmit = e => {
      e.preventdefault();
      if (!orders) return;
      
      addOrder(orders);
      setOrders("");
    }
    return (
      <form onSubmit={handleSubmit}>
        <input
        type="text"
        className="input"
        orders={orders}
        placeholder="Add a new Order"
        onChange={e => setOrders(e.target.order)}
        />
      </form>
    );
  } 
  
export const Coffeebay = () => {

  const [orders, setOrders] = useState([
    {
      name: "Espresso",
      isReady: true,
    },
    {
      name: "Cappuccino",
      isReady: false,
    },
    {
      name: "Latte Macchiato",
      isReady: false,
    },
  ]);

  const addOrder = name => {
    const newOrders = [...orders, { name, isReady: false }];
    setOrders(newOrders);
  };

  const completeOrder = index => {
    const newOrders = [...orders];
    newOrders[index].completed = true;
    setOrders(newOrders)
  }

  const removeOrder = index => {
    const newOrders = [...orders];
    newOrders.splice(index, 1);
    setOrders(newOrders);
  }

  return (
    <div className="order-container">
      <div className="header">ORDERS</div>
      <div className="orders">
        {orders.map((order, index) => (
          <Order 
          order={order} 
          index={index} 
          completeOrder={completeOrder}
          removeOrder={removeOrder}
          key={index} 
          />
        ))}
      </div>
      <div className="create-order" >
         <CreateOrder addOrder={addOrder} />
      </div>
    </div>
  );
};
