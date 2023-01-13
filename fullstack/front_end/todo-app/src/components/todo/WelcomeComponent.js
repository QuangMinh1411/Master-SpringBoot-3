import React from "react";
import { Link, useParams } from "react-router-dom";
export const WelcomeComponent = () => {
  const { username } = useParams();

  return (
    <div className="welcome">
      <h1>Welcome {username} </h1>
      <div>
        Your to dos: <Link to="/todos">here</Link>
      </div>
    </div>
  );
};
