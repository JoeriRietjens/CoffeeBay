import React from "react";

export const Product = ({ orders }) => {

  return (
    <ul>
      { orders.map((name, idex) => {
        return <li key={idex}>{name}</li>
      })}
    </ul>
  )
};
