import React from "react";

export const Product = ({ orders, setOrders }) => {

  return (
    <ul>
      { orders.map((name, idex) => {
        return <li key={idex}>{name}</li>
      })}
    </ul>
  )
};
