import React from "react";
import { useState } from "react";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";
function LoginComponent() {
  const [username, setUsername] = useState("heavenlight");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);

  const authContext = useAuth();
  const navigate = useNavigate();

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (authContext.login(username, password)) {
      navigate(`/welcome/${username}`);
    } else {
      setError(true);
    }
  };
  return (
    <div className="Login">
      {error && (
        <div className="errorMessage">
          Authentication Failed? Check credentials
        </div>
      )}
      <div className="LoginForm">
        <div>
          <label>User name</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}

export default LoginComponent;
