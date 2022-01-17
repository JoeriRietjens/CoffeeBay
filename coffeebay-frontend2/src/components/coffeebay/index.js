
import Stomp from "stompjs";
import { useEffect, useState } from "react";

export const Coffeebay = () => {

    const [product, setProduct] = useState([]);

    useEffect(() => {
      console.log(product);
    }, [product])

    const connect = () => {
      const socket = new WebSocket("ws://localhost:8080/coffeebay-socket");
      global.stompClient = Stomp.over(socket);
      global.stompClient.connect({}, onConnected, onError);
    }

    const onConnected = () => {
      console.log("here")
      global.stompClient.subscribe("/topic/public", onMessageReceived);
      /*
      global.stompClient.send("/app/chat.newUser",
        {},
        JSON.stringify({ sender: global.username, type: "CONNECT" })
      );
      */
    };

    const onMessageReceived = (payload) => {
      const message = JSON.parse(payload.body);
      console.log(message);
      if(message.type === "CONNECT"){
        console.log("here");
      }
      if(message.type === "CHAT"){
        console.log("here2");
        console.log("Message content: " + message.content.products[0]);
        setProduct(product => [...product, ...message.content.products]);
      }
      else{
        console.log("Whut?")
      }
    }
    
    const onError = (error) => {
        console.log("Could not find the connection you were looking for. Move along. Or, Refresh the page!");
    };
  
  
  return (
    <div>
        <button onClick={() => {connect();}}>Connect</button>
          <ul>
          { product.map((p) => (
            <li>{p.name}</li>))}
        </ul> 
    </div>
  );
}

