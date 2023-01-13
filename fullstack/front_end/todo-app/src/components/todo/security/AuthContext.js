import { createContext, useContext, useState } from "react";

//1. Create context
export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

//2. Put some state in the context
//3.Share the created context to other components

const AuthProvider = ({ children }) => {
  const [isAuthenticated, setAuthenticated] = useState(false);
  const login = (username, password) => {
    if (username === "heavenlight" && password === "1234") {
      setAuthenticated(true);
      return true;
    } else {
      setAuthenticated(false);
      return false;
    }
  };

  const logout = () => {
    setAuthenticated(false);
  };
  return (
    <AuthContext.Provider
      value={{ isAuthenticated, setAuthenticated, login, logout }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export default AuthProvider;

//
