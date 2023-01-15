import React from "react";
import { useAuth } from "./security/AuthContext";
const FooterComponent = () => {
  const authContext = useAuth();
  const isAuthenticated = authContext.isAuthenticated;
  let username = "";
  if (isAuthenticated) {
    username = authContext.username;
  }
  return (
    <footer>
      <div className="container">
        To Do List
        {isAuthenticated && <div>{username} to do list</div>}
      </div>
    </footer>
  );
};

export default FooterComponent;
